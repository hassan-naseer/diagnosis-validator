package com.codevalidator.code_validator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "mapped_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MappedCode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String code;
    
    @Column(name = "formatted_code")
    private String formattedCode;
    
    @Column(length = 1000)
    private String description;
    
    @Column(name = "code_system")
    private String codeSystem;  // ICD10CM, ICD9CM, SNOMED
    
    @Column(name = "disease_category")
    private String diseaseCategory;
    
    @Column(name = "chapter")
    private String chapter;


    // NEW FIELDS FOR HIERARCHY
    @Column(name = "subcategory")
    private String subcategory;
        
    @Column(name = "subcategory_level_2")
    private String subcategoryLevel2;
        
    @Column(name = "is_valid")
    private Boolean isValid;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;


    @Column(name = "mapping_method", length = 50)
    private String mappingMethod;  // "EXACT", "TRAILING_ZERO", "GEMS"
    
    // Constructor for easy creation
    public MappedCode(String code, String formattedCode, String description, 
                      String codeSystem, String diseaseCategory, String chapter, String subcategory, String subcategoryLevel2,
                      Boolean isValid,
                      String mappingMethod) {
        this.code = code;
        this.formattedCode = formattedCode;
        this.description = description;
        this.codeSystem = codeSystem;
        this.diseaseCategory = diseaseCategory;
        this.chapter = chapter;
        this.subcategory = subcategory;
        this.subcategoryLevel2 = subcategoryLevel2;
        this.isValid = isValid;
        this.mappingMethod = mappingMethod;
        this.createdAt = LocalDateTime.now();
    }

    public String getMappingMethod() {
        return mappingMethod;
    }
    
    public void setMappingMethod(String mappingMethod) {
        this.mappingMethod = mappingMethod;
    }
}