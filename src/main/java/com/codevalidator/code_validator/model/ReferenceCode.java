package com.codevalidator.code_validator.model;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenceCode {
    private String rawCode;           // "E1165" from file
    private String formattedCode;     // "E11.65" with decimal
    private String description;       // "Type 2 diabetes mellitus with hyperglycemia"
    private String chapter;           // "E" (Endocrine)
    private String category;          // "E11" (Type 2 diabetes)
    private boolean isDiabetes;       // true if E08-E13
}
