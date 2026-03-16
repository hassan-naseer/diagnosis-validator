package com.codevalidator.code_validator.service;

import com.codevalidator.code_validator.model.GlobalVariable;
import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.GlobalVariableRepository;
import com.codevalidator.code_validator.repository.MappedCodeRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GlobalVariableService {
    
    private final GlobalVariableRepository globalVariableRepository;
    private final MappedCodeRepository mappedCodeRepository;
    
    public GlobalVariableService(GlobalVariableRepository globalVariableRepository,
                                MappedCodeRepository mappedCodeRepository) {
        this.globalVariableRepository = globalVariableRepository;
        this.mappedCodeRepository = mappedCodeRepository;
    }
    
    // @PostConstruct
    @EventListener(ApplicationReadyEvent.class)
    public void initializeGlobalVariables() {
        System.out.println("Initializing Global Variables from ICD-10 hierarchy...");
        
        // Get all ICD-10 codes
        List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
        Set<GlobalVariable> gvs = new HashSet<>();
        
        // Extract unique Chapters
        allCodes.stream()
            .filter(c -> c.getChapter() != null)
            .map(MappedCode::getChapter)
            .distinct()
            .forEach(chapter -> {
                gvs.add(new GlobalVariable(
                    chapter,
                    "CHAPTER",
                    chapter,
                    null,
                    null,
                    null
                ));
            });
        
        // Extract unique Categories
        allCodes.stream()
            .filter(c -> c.getDiseaseCategory() != null)
            .collect(Collectors.groupingBy(MappedCode::getDiseaseCategory))
            .forEach((category, codes) -> {
                String chapter = codes.get(0).getChapter();
                gvs.add(new GlobalVariable(
                    category,
                    "CATEGORY",
                    chapter,
                    category,
                    null,
                    null
                ));
            });
        
        // Extract unique Subcategories
        allCodes.stream()
            .filter(c -> c.getSubcategory() != null)
            .collect(Collectors.groupingBy(c -> 
                c.getDiseaseCategory() + "|" + c.getSubcategory()
            ))
            .forEach((key, codes) -> {
                MappedCode sample = codes.get(0);
                gvs.add(new GlobalVariable(
                    sample.getSubcategory(),
                    "SUBCATEGORY",
                    sample.getChapter(),
                    sample.getDiseaseCategory(),
                    sample.getSubcategory(),
                    null
                ));
            });
        
        // Extract unique Level 2
        allCodes.stream()
            .filter(c -> c.getSubcategoryLevel2() != null)
            .collect(Collectors.groupingBy(c -> 
                c.getDiseaseCategory() + "|" + c.getSubcategory() + "|" + c.getSubcategoryLevel2()
            ))
            .forEach((key, codes) -> {
                MappedCode sample = codes.get(0);
                gvs.add(new GlobalVariable(
                    sample.getSubcategoryLevel2(),
                    "LEVEL2",
                    sample.getChapter(),
                    sample.getDiseaseCategory(),
                    sample.getSubcategory(),
                    sample.getSubcategoryLevel2()
                ));
            });
        
        // Save all GVs
        globalVariableRepository.saveAll(gvs);
        
        System.out.println("Created " + gvs.size() + " Global Variables:");
        System.out.println("  - Chapters: " + gvs.stream().filter(g -> g.getHierarchyLevel().equals("CHAPTER")).count());
        System.out.println("  - Categories: " + gvs.stream().filter(g -> g.getHierarchyLevel().equals("CATEGORY")).count());
        System.out.println("  - Subcategories: " + gvs.stream().filter(g -> g.getHierarchyLevel().equals("SUBCATEGORY")).count());
        System.out.println("  - Level 2: " + gvs.stream().filter(g -> g.getHierarchyLevel().equals("LEVEL2")).count());
    }
    
    public List<GlobalVariable> getAllGlobalVariables() {
        return globalVariableRepository.findAll();
    }
    
    public List<MappedCode> getCodesForGlobalVariable(GlobalVariable gv) {
        List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
        return allCodes.stream()
            .filter(code -> matchesGlobalVariable(code, gv))
            .collect(Collectors.toList());
    }
    
    private boolean matchesGlobalVariable(MappedCode code, GlobalVariable gv) {
        switch (gv.getHierarchyLevel()) {
            case "CHAPTER":
                return gv.getChapter().equals(code.getChapter());
                
            case "CATEGORY":
                return gv.getCategory().equals(code.getDiseaseCategory());
                
            case "SUBCATEGORY":
                return gv.getCategory().equals(code.getDiseaseCategory()) &&
                       gv.getSubcategory().equals(code.getSubcategory());
                
            case "LEVEL2":
                return gv.getCategory().equals(code.getDiseaseCategory()) &&
                       gv.getSubcategory().equals(code.getSubcategory()) &&
                       gv.getLevel2().equals(code.getSubcategoryLevel2());
                
            default:
                return false;
        }
    }
}