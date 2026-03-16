package com.codevalidator.code_validator.controller;


import com.codevalidator.code_validator.model.GlobalVariable;
import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.MappedCodeRepository;
import com.codevalidator.code_validator.service.GlobalVariableService;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.apache.bcel.classfile.Module.Open;
import org.aspectj.weaver.ast.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    private final GlobalVariableService globalVariableService;
    
    public DiagnosisController(MappedCodeRepository mappedCodeRepository,
        GlobalVariableService globalVariableService){
        this.mappedCodeRepository = mappedCodeRepository;
        this.globalVariableService = globalVariableService;
    }
    
    // Get all codes
    @GetMapping
    public List<MappedCode> getAllCodes() {
        return mappedCodeRepository.findAll();
    }

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
    
    // Export Global Variables to Excel
    @GetMapping("/export/global-variables")
    public ResponseEntity<byte[]> exportGlobalVariables() throws Exception {
        List<GlobalVariable> allGVs = globalVariableService.getAllGlobalVariables();
        List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
        // Create workbook
        Workbook workbook = new XSSFWorkbook();
        
        // ===== SHEET 1: SUMMARY =====
        Sheet summarySheet = workbook.createSheet("Summary");
        
        // Header style
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        // Create header row
        Row summaryHeader = summarySheet.createRow(0);
        String[] summaryHeaders = {"GV Name", "Hierarchy Level", "Chapter", "Category", "Subcategory", "Level 2", "ICD10 Count", "ICD9 Count", "Total Codes"};
        for (int i = 0; i < summaryHeaders.length; i++) {
            Cell cell = summaryHeader.createCell(i);
            cell.setCellValue(summaryHeaders[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Add summary data
        int summaryRowNum = 1;
        for (GlobalVariable gv : allGVs) {
            List<MappedCode> gvCodes = globalVariableService.getCodesForGlobalVariable(gv);
            long icd10Count = gvCodes.stream().filter(c -> "ICD10CM".equals(c.getCodeSystem())).count();
            long icd9Count = gvCodes.stream().filter(c -> "ICD9CM".equals(c.getCodeSystem())).count();
            
            Row row = summarySheet.createRow(summaryRowNum++);
            row.createCell(0).setCellValue(gv.getName());
            row.createCell(1).setCellValue(gv.getHierarchyLevel());
            row.createCell(2).setCellValue(gv.getChapter() != null ? gv.getChapter() : "");
            row.createCell(3).setCellValue(gv.getCategory() != null ? gv.getCategory() : "");
            row.createCell(4).setCellValue(gv.getSubcategory() != null ? gv.getSubcategory() : "");
            row.createCell(5).setCellValue(gv.getLevel2() != null ? gv.getLevel2() : "");
            row.createCell(6).setCellValue(icd10Count);
            row.createCell(7).setCellValue(icd9Count);
            row.createCell(8).setCellValue(gvCodes.size());
        }
        
        // Auto-size summary columns
        for (int i = 0; i < summaryHeaders.length; i++) {
            summarySheet.autoSizeColumn(i);
        }
        
        // ===== SHEET 2: ALL CODES =====
        Sheet codesSheet = workbook.createSheet("All_Codes");
        
        // Create header row
        Row codesHeader = codesSheet.createRow(0);
        String[] codesHeaders = {"GV Name", "Hierarchy Level", "Code System", "Code", "Description", "Mapping Method"};
        for (int i = 0; i < codesHeaders.length; i++) {
            Cell cell = codesHeader.createCell(i);
            cell.setCellValue(codesHeaders[i]);
            cell.setCellStyle(headerStyle);
        }
        
        // Add all codes data
        int codesRowNum = 1;
        for (GlobalVariable gv : allGVs) {
            List<MappedCode> gvCodes = globalVariableService.getCodesForGlobalVariable(gv);
            
            for (MappedCode code : gvCodes) {
                Row row = codesSheet.createRow(codesRowNum++);
                row.createCell(0).setCellValue(gv.getName());
                row.createCell(1).setCellValue(gv.getHierarchyLevel());
                row.createCell(2).setCellValue(code.getCodeSystem());
                row.createCell(3).setCellValue(code.getFormattedCode());
                row.createCell(4).setCellValue(code.getDescription());
                row.createCell(5).setCellValue(code.getMappingMethod() != null ? code.getMappingMethod() : "UNKNOWN");  //ADD THIS LINE
            }
        }
        
        // Auto-size codes columns
        for (int i = 0; i < codesHeaders.length; i++) {
            codesSheet.autoSizeColumn(i);
        }

        // ===== SHEET 3: UNMAPPED CODES =====
        Sheet unmappedSheet = workbook.createSheet("Unmapped_Codes");

        // Create header row
        Row unmappedHeader = unmappedSheet.createRow(0);
        String[] unmappedHeaders = {"Code System", "Code", "Description", "Reason"};
        for (int i = 0; i < unmappedHeaders.length; i++) {
            Cell cell = unmappedHeader.createCell(i);
            cell.setCellValue(unmappedHeaders[i]);
            cell.setCellStyle(headerStyle);
        }

        // Get all unmapped codes (codes with null category)
        List<MappedCode> unmappedCodes = mappedCodeRepository.findAll().stream()
            .filter(c -> c.getDiseaseCategory() == null || c.getChapter() == null)
            .sorted((a, b) -> a.getCodeSystem().compareTo(b.getCodeSystem()))
            .toList();

        // Add unmapped codes data
        int unmappedRowNum = 1;
        for (MappedCode code : unmappedCodes) {
            Row row = unmappedSheet.createRow(unmappedRowNum++);
            row.createCell(0).setCellValue(code.getCodeSystem());
            row.createCell(1).setCellValue(code.getFormattedCode());
            row.createCell(2).setCellValue(code.getDescription());
            
            // Determine reason for being unmapped
            String reason = "No GEMs mapping found";
            if ("ICD10CM".equals(code.getCodeSystem())) {
                reason = "Missing hierarchy in reference data";
            }
            row.createCell(3).setCellValue(reason);
        }

        // Auto-size unmapped columns
        for (int i = 0; i < unmappedHeaders.length; i++) {
            unmappedSheet.autoSizeColumn(i);
        }

        System.out.println("Added " + unmappedCodes.size() + " unmapped codes to sheet");

        
        // Write to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename=Global_Variables_All_Systems.xlsx");
        httpHeaders.add("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        
        return ResponseEntity.ok()
            .headers(httpHeaders)
            .body(outputStream.toByteArray());
    }
    @GetMapping("/stats/mapping-methods")
    public ResponseEntity<Map<String, Object>> getMappingMethodStats() {
        List<MappedCode> allCodes = mappedCodeRepository.findAll();
        
        Map<String, Long> methodCounts = allCodes.stream()
            .filter(c -> "ICD9CM".equals(c.getCodeSystem()))
            .collect(Collectors.groupingBy(
                c -> c.getMappingMethod() != null ? c.getMappingMethod() : "UNKNOWN",
                Collectors.counting()
            ));
        
        Map<String, Object> response = new HashMap<>();
        response.put("totalICD9Codes", allCodes.stream().filter(c -> "ICD9CM".equals(c.getCodeSystem())).count());
        response.put("byMappingMethod", methodCounts);
        
        return ResponseEntity.ok(response);
    }




}
