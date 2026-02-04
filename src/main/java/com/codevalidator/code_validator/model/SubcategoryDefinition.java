package com.codevalidator.code_validator.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDefinition {
    private String codePrefix;        // "E11"
    private String parentCategory;    // "Diabetes mellitus"
    private String subcategoryName;   // "Type 2 diabetes mellitus"
    private String level2Prefix;      // "E11.2" (optional, for deeper level)
    private String level2Name;        // "Type 2 diabetes with kidney complications"
    
    // Check if a code matches this subcategory
    public boolean matchesSubcategory(String code) {
        return code.startsWith(codePrefix);
    }
    
    // Check if a code matches level 2 subcategory
    public boolean matchesLevel2(String code) {
        if (level2Prefix == null) return false;
        return code.startsWith(level2Prefix);
    }
}