package com.codevalidator.code_validator.service;

import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.MappedCodeRepository;

import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
// @DependsOn("referenceDataService")
public class Icd9Service {
    
    private Map<String, String> icd9Codes = new HashMap<>();
    private final MappedCodeRepository mappedCodeRepository;
    private final GemsService gemsService;
    
    public Icd9Service(MappedCodeRepository mappedCodeRepository, GemsService gemsService) {
        this.mappedCodeRepository = mappedCodeRepository;
        this.gemsService = gemsService;
    }
    
    // @PostConstruct
    public void loadIcd9Codes() {
        System.out.println("Loading ICD-9-CM codes...");
        
        try {
            ClassPathResource resource = new ClassPathResource("reference-data/icd9/CMS32_DESC_LONG_DX.txt");
            
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    
                    // Format: "0010 Cholera due to vibrio cholerae"
                    String[] parts = line.split("\\s+", 2);
                    if (parts.length == 2) {
                        String rawCode = parts[0].trim();
                        String description = parts[1].trim();
                        
                        // Format code with decimal
                        String formattedCode = formatIcd9Code(rawCode);
                        
                        icd9Codes.put(formattedCode, description);
                    }
                }
            }
            
            System.out.println("Loaded " + icd9Codes.size() + " ICD-9-CM codes");
            
            // Map to ICD-10 hierarchy and save
            mapAndSaveIcd9Codes();
            
        } catch (Exception e) {
            System.err.println("Error loading ICD-9 codes: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private String formatIcd9Code(String rawCode) {
        // Convert "0010" to "001.0", "25000" to "250.00", etc.
        if (rawCode.length() < 3) {
            return rawCode;
        }
        
        // Determine where decimal should go
        if (rawCode.startsWith("E") || rawCode.startsWith("V")) {
            // E and V codes: E8000 -> E800.0
            if (rawCode.length() > 4) {
                return rawCode.substring(0, 4) + "." + rawCode.substring(4);
            }
            return rawCode;
        } else {
            // Numeric codes: 25000 -> 250.00
            if (rawCode.length() > 3) {
                return rawCode.substring(0, 3) + "." + rawCode.substring(3);
            }
            return rawCode;
        }
    }
    
    private void mapAndSaveIcd9Codes() {
        System.out.println("Mapping ICD-9 codes using CMS GEMs...");
        
        int savedCount = 0;
        int mappedCount = 0;
        int unmappedCount = 0;
        
        for (Map.Entry<String, String> entry : icd9Codes.entrySet()) {
            String formattedCode = entry.getKey();
            String description = entry.getValue();
            

            // USE GEMS to get ICD-10 hierarchy
            GemsService.Icd9ToIcd10Mapping mapping = gemsService.getIcd10HierarchyForIcd9Code(formattedCode);
            
            if (mapping != null) {
                // GEMS mapping found - use ICD-10 hierarchy!
                MappedCode mappedCode = new MappedCode(
                    formattedCode.replace(".", ""),  // Raw code: "25000"
                    formattedCode,                    // Formatted: "250.00"
                    description,
                    "ICD9CM",
                    mapping.category,       // From ICD-10!
                    mapping.chapter,        // From ICD-10!
                    mapping.subcategory,    // From ICD-10! (might be null)
                    mapping.level2,         // From ICD-10! (might be null)
                    true,
                    mapping.mappingMethod  // Pass the mapping method
                );
                
                mappedCodeRepository.save(mappedCode);
                savedCount++;
                mappedCount++;
            } else {
                //No GEMs mapping - save without hierarchy
                MappedCode mappedCode = new MappedCode(
                    formattedCode.replace(".", ""),
                    formattedCode,
                    description,
                    "ICD9CM",
                    null,  // No category
                    null,  // No chapter
                    null,  // No subcategory
                    null,  // No level2
                    true,
                    "UNMAPPED"  // Flag as unmapped
                );
                mappedCodeRepository.save(mappedCode);
                savedCount++;
                unmappedCount++;
            }
        }
        
        System.out.println("Successfully saved " + savedCount + " ICD-9 codes to database");
        System.out.println("Mapped using GEMs: " + mappedCount + " (" + (mappedCount * 100 / savedCount) + "%)");
        System.out.println("No GEMs mapping: " + unmappedCount + " (" + (unmappedCount * 100 / savedCount) + "%)");
    }
}
