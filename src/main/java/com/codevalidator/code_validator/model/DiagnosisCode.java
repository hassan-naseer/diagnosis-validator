package com.codevalidator.code_validator.model;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisCode {
    private String code;
    private String codeSystem; // SNOMED, ICD9CM, ICD10CM
    private String gvName;
    private String category;
}
