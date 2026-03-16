package com.codevalidator.code_validator.service;

import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.MappedCodeRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class GemsService {
    
    // Store the mappings: ICD-9 code → List of ICD-10 codes
    // Why List? Because one ICD-9 can map to multiple ICD-10 codes!
    private Map<String, List<String>> icd9ToIcd10Map = new HashMap<>();
    private Map<String, MappedCode> icd10CodeCache = new HashMap<>();
    private boolean cacheLoaded = false;
    
    // Need this to look up ICD-10 codes in database
    private final MappedCodeRepository mappedCodeRepository;
    
    // Constructor injection
    public GemsService(MappedCodeRepository mappedCodeRepository) {
        this.mappedCodeRepository = mappedCodeRepository;
    }
    
    // Next: Load the GEMs file
    @PostConstruct
    public void loadGemsMapping() {
        System.out.println("Loading CMS GEMs (ICD-9 to ICD-10 mappings)...");
        // // FIRST: Load all ICD-10 codes into cache
        // System.out.println("Caching ICD-10 codes for fast lookup...");
        // List<MappedCode> allIcd10Codes = mappedCodeRepository.findAll().stream()
        // .filter(c -> "ICD10CM".equals(c.getCodeSystem()))
        // .toList();
        // for (MappedCode code : allIcd10Codes) {
        //     icd10CodeCache.put(code.getFormattedCode(), code);
        // }
        // System.out.println("Cached " + icd10CodeCache.size() + " ICD-10 codes");
        // THEN: Load GEMs mappings
        try {
            ClassPathResource resource = new ClassPathResource("reference-data/icd9/2018_I9gem.txt");
            
            try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                    
                    String line;
                    int lineCount = 0;
                    
                    while ((line = reader.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;
                        
                        String[] parts = line.split("\\s+");
                        if (parts.length >= 2) {
                            String icd9Raw = parts[0].trim();
                            String icd10Raw = parts[1].trim();
                            
                            String icd9Formatted = formatIcd9Code(icd9Raw);
                            String icd10Formatted = formatIcd10Code(icd10Raw);
                            
                            icd9ToIcd10Map.computeIfAbsent(icd9Formatted, k -> new ArrayList<>())
                            .add(icd10Formatted);
                            
                            lineCount++;
                        }
                    }
                    
                    System.out.println("Loaded " + lineCount + " GEMs mappings");
                    System.out.println("Unique ICD-9 codes: " + icd9ToIcd10Map.size());
                }
                
        } catch (Exception e) {
                System.err.println("Error loading GEMs file: " + e.getMessage());
                e.printStackTrace();
            }
    }
    
    
    private String formatIcd9Code(String rawCode) {
        // Convert "25000" → "250.00"
        // Convert "0010"  → "001.0"
        // Convert "E8000" → "E800.0"
        
        if (rawCode.length() < 3) {
            return rawCode; // Too short, return as-is
        }
        
        // Handle E and V codes differently
        if (rawCode.startsWith("E") || rawCode.startsWith("V")) {
            // E codes: "E8000" → "E800.0"
            if (rawCode.length() > 4) {
                return rawCode.substring(0, 4) + "." + rawCode.substring(4);
            }
            return rawCode;
        } else {
            // Numeric codes: "25000" → "250.00"
            if (rawCode.length() > 3) {
                return rawCode.substring(0, 3) + "." + rawCode.substring(3);
            }
            return rawCode;
        }
    }
    
    private String formatIcd10Code(String rawCode) {
        // Convert "E119"  → "E11.9"
        // Convert "A000"  → "A00.0"
        // Convert "A0100" → "A01.00"
        
        if (rawCode.length() < 3) {
            return rawCode; // Too short, return as-is
        }
        
        // ICD-10: decimal always after 3rd character
        if (rawCode.length() > 3) {
            return rawCode.substring(0, 3) + "." + rawCode.substring(3);
        }
        return rawCode;
    }
    public Icd9ToIcd10Mapping getIcd10HierarchyForIcd9Code(String icd9Code) {
        
        ensureCacheLoaded();
        // Step 1: Get mapped ICD-10 code(s) from our map
        List<String> icd10Codes = icd9ToIcd10Map.get(icd9Code);
        
        if (icd10Codes == null || icd10Codes.isEmpty()) {
            // No mapping found in GEMs
            return null;
        }
        
        // Step 2: Use first mapping 
        // (Most common: 1:1. For 1:many, we take the first - can improve later)
        String icd10Code = icd10Codes.get(0);

        // Step 3: Look up in cache (NOT database!)
         MappedCode icd10Record = icd10CodeCache.get(icd10Code);
         String mappingMethod = "EXACT";
        
        
        if (icd10Record == null) {
            // ICD-10 code from GEMs not found in our cache
            icd10Record = tryTrailingZeroVariants(icd10Code);
            if (icd10Record != null) {
                mappingMethod = "TRAILING_ZERO";  //Flag as fallback
            }
        }

        if (icd10Record == null) {
            return null;
        }
        
        // Step 5: Return the hierarchy!
        return new Icd9ToIcd10Mapping(
            icd10Record.getChapter(),
            icd10Record.getDiseaseCategory(),
            icd10Record.getSubcategory(),
            icd10Record.getSubcategoryLevel2(),
            mappingMethod
        );
    }
    
    //  NEW METHOD: Try trailing zero variants
    private MappedCode tryTrailingZeroVariants(String icd10Code) {
        // Case 1: GEMs has trailing zero (K74.60) - try removing it (K74.6)
        if (icd10Code.endsWith("0") && icd10Code.contains(".")) {
            String withoutTrailingZero = icd10Code.substring(0, icd10Code.length() - 1);
            MappedCode found = icd10CodeCache.get(withoutTrailingZero);
            if (found != null) {
                System.out.println("Trailing zero fallback: " + icd10Code + " → " + withoutTrailingZero);
                return found;
            }
        }
        
        // Case 2: GEMs doesn't have trailing zero (K74.6) - try adding it (K74.60)
        if (!icd10Code.endsWith("0") && icd10Code.contains(".")) {
            String withTrailingZero = icd10Code + "0";
            MappedCode found = icd10CodeCache.get(withTrailingZero);
            if (found != null) {
                System.out.println("Trailing zero fallback: " + icd10Code + " → " + withTrailingZero);
                return found;
            }
        }
        
        return null;
    }



    // Inner class to hold the mapping result
    public static class Icd9ToIcd10Mapping {
        public String chapter;
        public String category;
        public String subcategory;
        public String level2;
        public String mappingMethod;
        
        public Icd9ToIcd10Mapping(String chapter, String category, String subcategory, String level2, String mappingMethod) {
            this.chapter = chapter;
            this.category = category;
            this.subcategory = subcategory;
            this.level2 = level2;
            this.mappingMethod = mappingMethod;
            
        }
    }
    private synchronized void ensureCacheLoaded() {
        // Only build cache once
        if (cacheLoaded) {
            return; // Already loaded
        }
        
        System.out.println("Building ICD-10 code cache...");
        List<MappedCode> allIcd10Codes = mappedCodeRepository.findAll().stream()
            .filter(c -> "ICD10CM".equals(c.getCodeSystem()))
            .toList();
        
        for (MappedCode code : allIcd10Codes) {
            icd10CodeCache.put(code.getFormattedCode(), code);
        }

        cacheLoaded = true;
        System.out.println("Cached " + icd10CodeCache.size() + " ICD-10 codes");
    }
        
}