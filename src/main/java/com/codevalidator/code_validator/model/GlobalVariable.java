package com.codevalidator.code_validator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "global_variables")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalVariable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 500)
    private String name;  // "Diabetes mellitus" or "Type 2 diabetes with kidney complications"
    
    @Column(name = "hierarchy_level", nullable = false, length = 50)
    private String hierarchyLevel;  // "CHAPTER", "CATEGORY", "SUBCATEGORY", "LEVEL2"
    
    @Column(name = "chapter", length = 255)
    private String chapter;
    
    @Column(name = "category", length = 255)
    private String category;
    
    @Column(name = "subcategory", length = 255)
    private String subcategory;
    
    @Column(name = "level_2", length = 255)
    private String level2;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public GlobalVariable(String name, String hierarchyLevel, String chapter, 
                         String category, String subcategory, String level2) {
        this.name = name;
        this.hierarchyLevel = hierarchyLevel;
        this.chapter = chapter;
        this.category = category;
        this.subcategory = subcategory;
        this.level2 = level2;
        this.createdAt = LocalDateTime.now();
    }
}
