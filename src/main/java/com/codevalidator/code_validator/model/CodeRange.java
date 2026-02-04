package com.codevalidator.code_validator.model;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeRange {
    private String startCode;  // "E08"
    private String endCode;    // "E13"
    private String category;   // "Diabetes Mellitus"
    private String chapter;    // "Endocrine, nutritional and metabolic diseases"
    
    // Check if a code falls within this range
    public boolean contains(String code) {
        // Extract the category part (first 3 chars)
        String codeCategory = code.substring(0, Math.min(3, code.length()));
        return codeCategory.compareTo(startCode) >= 0 && codeCategory.compareTo(endCode) <= 0;
    }
}