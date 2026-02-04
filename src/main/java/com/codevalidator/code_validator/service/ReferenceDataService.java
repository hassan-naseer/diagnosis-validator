package com.codevalidator.code_validator.service;


import com.codevalidator.code_validator.model.CodeRange;
import com.codevalidator.code_validator.model.ReferenceCode;
import com.codevalidator.code_validator.model.SubcategoryDefinition;
import com.codevalidator.code_validator.repository.MappedCodeRepository;

import org.springframework.stereotype.Service;
import org.apache.commons.collections4.Get;
import org.springframework.core.io.ClassPathResource;

import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codevalidator.code_validator.model.MappedCode;


@Service
public class ReferenceDataService {
    
    // Store all reference codes: key = formatted code, value = ReferenceCode object
    private Map<String, ReferenceCode> icd10Codes = new HashMap<>();
    private final DiseaseCategoryService diseaseCategoryService;

    // Inject the repository
    private final MappedCodeRepository mappedCodeRepository;

    private final SubcategoryService subcategoryService;

    //UPDATE CONSTRUCTOR to include repository
    public ReferenceDataService(DiseaseCategoryService diseaseCategoryService,
                                MappedCodeRepository mappedCodeRepository,
                                SubcategoryService subcategoryService) {
        this.diseaseCategoryService = diseaseCategoryService;
        this.mappedCodeRepository = mappedCodeRepository;
        this.subcategoryService = subcategoryService;
    }

    // Runs automatically when Spring Boot starts
    @PostConstruct
    public void loadReferenceData() {
        System.out.println("Loading ICD-10 reference data...");
        loadIcd10Codes();
        System.out.println("Loaded " + icd10Codes.size() + " ICD-10 codes");
        saveMappedCodesToDatabase();
    }
    
    private void loadIcd10Codes() {
        try {
            ClassPathResource resource = new ClassPathResource("reference-data/icd10/icd10cm_codes_2025.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;
                
                // Parse line: first 5-7 chars = code, rest = description
                String rawCode = line.substring(0, Math.min(7, line.length())).trim();
                String description = line.substring(Math.min(7, line.length())).trim();
                
                // Format the code (add decimal point)
                String formattedCode = formatIcd10Code(rawCode);
                
                // Extract chapter and category
                String chapter = rawCode.substring(0, 1); // First letter
                String category = rawCode.substring(0, 3); // First 3 chars
                
                // Check if it's a diabetes code (E08-E13)
                boolean isDiabetes = category.compareTo("E08") >= 0 && category.compareTo("E13") <= 0;
                
                // Create ReferenceCode object
                ReferenceCode refCode = new ReferenceCode(
                    rawCode,
                    formattedCode,
                    description,
                    chapter,
                    category,
                    isDiabetes
                );
                
                // Store in map
                icd10Codes.put(formattedCode, refCode);
            }
            
            reader.close();
        } catch (Exception e) {
            System.err.println("Error loading ICD-10 codes: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Format code: "E1165" → "E11.65"
    private String formatIcd10Code(String rawCode) {
        if (rawCode.length() <= 3) {
            return rawCode; // Too short, return as is
        }
        // Insert decimal after 3rd character
        return rawCode.substring(0, 3) + "." + rawCode.substring(3);
    }
    
    // Public method to validate a code
    public boolean isValidCode(String code) {
        return icd10Codes.containsKey(code);
    }
    
    // Get reference code details
    public ReferenceCode getCodeDetails(String code) {
        return icd10Codes.get(code);
    }
    
    // Check if code is diabetes-related
    public boolean isDiabetesCode(String code) {
        ReferenceCode refCode = icd10Codes.get(code);
        return refCode != null && refCode.isDiabetes();
    }

    
    // Save all mapped codes to database
    public void saveMappedCodesToDatabase() {
        System.out.println("\n Saving mapped codes to database...");
            
        int savedCount = 0;
            
        for (Map.Entry<String, ReferenceCode> entry : icd10Codes.entrySet()) {
            String formattedCode = entry.getKey();
            ReferenceCode refCode = entry.getValue();
                
            // Get disease category
            CodeRange category = diseaseCategoryService.getCategoryForCode(formattedCode);

            // Get subcategory
            SubcategoryDefinition subcat = subcategoryService.getSubcategory(formattedCode);

            String subcategoryName = null;
            String subcategoryLevel2 = null;

            if (subcat != null) {
                subcategoryName = subcat.getSubcategoryName();
                // If it has level 2, use that; otherwise use level 1
                if (subcat.getLevel2Name() != null) {
                    subcategoryLevel2 = subcat.getLevel2Name();
                }
            }
                
            // Create MappedCode entity
            MappedCode mappedCode = new MappedCode(
                refCode.getRawCode(),
                refCode.getFormattedCode(),
                refCode.getDescription(),
                "ICD10CM",  // We know it's ICD-10 from our reference file
                category != null ? category.getCategory() : "Uncategorized",
                category != null ? category.getChapter() : "Unknown",
                subcategoryName,
                subcategoryLevel2,
                true  // Valid because it's from official CMS data
            );
                
            // Save to database
            mappedCodeRepository.save(mappedCode);
            savedCount++;
        }

        System.out.println("Successfully saved " + savedCount + " codes");
    }

}
