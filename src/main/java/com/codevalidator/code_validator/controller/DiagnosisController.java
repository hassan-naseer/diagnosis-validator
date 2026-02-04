package com.codevalidator.code_validator.controller;


import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.MappedCodeRepository;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.apache.bcel.classfile.Module.Open;
import org.aspectj.weaver.ast.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/codes")
public class DiagnosisController {
    
    private final MappedCodeRepository mappedCodeRepository;
    
    public DiagnosisController(MappedCodeRepository mappedCodeRepository) {
        this.mappedCodeRepository = mappedCodeRepository;
    }
    
    // Get all codes
    @GetMapping
    public List<MappedCode> getAllCodes() {
        return mappedCodeRepository.findAll();
    }
    
    // // Get codes by category
    // @GetMapping("/category/{category}")
    // public List<MappedCode> getCodesByCategory(@PathVariable String category) {
    //     return mappedCodeRepository.findByDiseaseCategory(category);
    // }
    
    // // Get summary statistics
    // @GetMapping("/stats")
    // public Map<String, Object> getStats() {
    //     List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
    //     Map<String, Long> categoryCount = allCodes.stream()
    //         .collect(Collectors.groupingBy(
    //             MappedCode::getDiseaseCategory,
    //             Collectors.counting()
    //         ));
        
    //     return Map.of(
    //         "totalCodes", allCodes.size(),
    //         "categoriesCount", categoryCount.size(),
    //         "byCategory", categoryCount
    //     );
    // }

        // Get detailed stats with subcategories
        @GetMapping("/stats/detailed")
        public Map<String, Object> getDetailedStats() {
            List<MappedCode> allCodes = mappedCodeRepository.findAll();
            
            // Count by category
            Map<String, Long> categoryCount = allCodes.stream()
                .collect(Collectors.groupingBy(MappedCode::getDiseaseCategory, Collectors.counting()));
            
            // Count by subcategory
            Map<String, Long> subcategoryCount = allCodes.stream()
                .filter(c -> c.getSubcategory() != null)
                .collect(Collectors.groupingBy(MappedCode::getSubcategory, Collectors.counting()));
            
            // Count by level 2
            Map<String, Long> level2Count = allCodes.stream()
                .filter(c -> c.getSubcategoryLevel2() != null)
                .collect(Collectors.groupingBy(MappedCode::getSubcategoryLevel2, Collectors.counting()));
            
            return Map.of(
                "totalCodes", allCodes.size(),
                "categoriesCount", categoryCount.size(),
                "subcategoriesCount", subcategoryCount.size(),
                "level2Count", level2Count.size(),
                "byCategory", categoryCount,
                "bySubcategory", subcategoryCount,
                "byLevel2", level2Count
            );
        }
        // Export as Excel with hierarchy
        @GetMapping("/export/excel-hierarchy")
        public ResponseEntity<byte[]> exportExcelHierarchy() throws Exception {
        List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
        // Create workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ICD-10 Codes Hierarchy");
        
        // Create header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // Create header row
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Code", "Chapter", "Category", "Subcategory", "Level 2", "Description"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Add data rows
        int rowNum = 1;
        for (MappedCode code : allCodes) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(code.getFormattedCode());
            row.createCell(1).setCellValue(code.getChapter() != null ? code.getChapter() : "");
            row.createCell(2).setCellValue(code.getDiseaseCategory() != null ? code.getDiseaseCategory() : "");
            row.createCell(3).setCellValue(code.getSubcategory() != null ? code.getSubcategory() : "");
            row.createCell(4).setCellValue(code.getSubcategoryLevel2() != null ? code.getSubcategoryLevel2() : "");
            row.createCell(5).setCellValue(code.getDescription());
        }
        
        // Auto-size columns
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
        // Write to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename=icd10_codes_hierarchy.xlsx");
        httpHeaders.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        
        return ResponseEntity.ok()
            .headers(httpHeaders)
            .body(outputStream.toByteArray());
    }
}
