package com.codevalidator.code_validator.repository;


import com.codevalidator.code_validator.model.MappedCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappedCodeRepository extends JpaRepository<MappedCode, Long> {
    
    // Spring automatically implements these methods!
    List<MappedCode> findByDiseaseCategory(String diseaseCategory);
    List<MappedCode> findByCodeSystem(String codeSystem);
    List<MappedCode> findByIsValid(Boolean isValid);


    // NEW METHODS FOR SUBCATEGORIES
    List<MappedCode> findBySubcategory(String subcategory);
    List<MappedCode> findBySubcategoryLevel2(String subcategoryLevel2);
    List<MappedCode> findByDiseaseCategoryAndSubcategory(String diseaseCategory, String subcategory);
}
