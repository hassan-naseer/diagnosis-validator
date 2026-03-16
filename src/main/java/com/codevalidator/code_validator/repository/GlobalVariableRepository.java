package com.codevalidator.code_validator.repository;

import com.codevalidator.code_validator.model.GlobalVariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalVariableRepository extends JpaRepository<GlobalVariable, Long> {
    
    List<GlobalVariable> findByHierarchyLevel(String hierarchyLevel);
    
    GlobalVariable findByName(String name);
}