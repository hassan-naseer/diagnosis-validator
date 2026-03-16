package com.codevalidator.code_validator.controller;

import com.codevalidator.code_validator.model.MappedCode;
import com.codevalidator.code_validator.repository.MappedCodeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ViewController {
    
    private final MappedCodeRepository mappedCodeRepository;
    
    public ViewController(MappedCodeRepository mappedCodeRepository) {
        this.mappedCodeRepository = mappedCodeRepository;
    }
    
    @GetMapping("/view-codes")
    @ResponseBody

    public String viewCodes() {
    List<MappedCode> allCodes = mappedCodeRepository.findAll();
    
    StringBuilder html = new StringBuilder();
    html.append("<!DOCTYPE html>");
    html.append("<html><head>");
    html.append("<title>Diagnosis Codes Hierarchy Viewer</title>");
    html.append("<style>");
    html.append("body { font-family: Arial, sans-serif; margin: 20px; background: #f5f5f5; }");
    html.append("h1 { color: #2c3e50; }");
    html.append(".controls { background: white; padding: 20px; border-radius: 8px; margin-bottom: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
    html.append(".controls h3 { margin-top: 0; color: #3498db; }");
    html.append(".filter-group { margin: 10px 0; }");
    html.append(".filter-group label { display: inline-block; width: 150px; font-weight: bold; }");
    html.append(".filter-group input, .filter-group select { padding: 8px; font-size: 14px; width: 300px; border: 1px solid #ddd; border-radius: 4px; }");
    html.append(".export-btn { padding: 10px 20px; background: #27ae60; color: white; border: none; border-radius: 4px; cursor: pointer; margin-left: 10px; }");
    html.append(".export-btn:hover { background: #229954; }");
    html.append(".result-count { margin: 10px 0; font-weight: bold; color: #2c3e50; }");
    html.append("table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 4px rgba(0,0,0,0.1); font-size: 13px; }");
    html.append("th { background: #3498db; color: white; padding: 10px 8px; text-align: left; position: sticky; top: 0; font-size: 12px; }");
    html.append("td { padding: 8px; border-bottom: 1px solid #ddd; }");
    html.append("tr:hover { background: #f8f9fa; }");
    html.append(".code-col { font-weight: bold; color: #2c3e50; }");
    html.append(".chapter-col { color: #7f8c8d; font-size: 11px; }");
    html.append(".category-col { color: #16a085; font-weight: 600; }");
    html.append(".subcat-col { color: #2980b9; }");
    html.append(".level2-col { color: #8e44ad; font-style: italic; }");
    html.append("</style>");
    html.append("</head><body>");
    
    // Header
    html.append("<h1>🏥 ICD-10 Codes - Hierarchical View</h1>");
    
    // Controls Section
    html.append("<div class='controls'>");
    html.append("<h3>🔍 Search & Export</h3>");
    
    html.append("<div class='filter-group'>");
    html.append("<label for='searchBox'>Search:</label>");
    html.append("<input type='text' id='searchBox' placeholder='Type to search code or description...' onkeyup='filterTable()'>");
    html.append("</div>");
    
    html.append("<div class='filter-group'>");
    html.append("<label>Export:</label>");
    html.append("<button class='export-btn' onclick='exportExcel()'>📊 Export to Excel</button>");
    html.append("<button class='export-btn' onclick='exportCSV()'>📄 Export to CSV</button>");
    html.append("</div>");
    
    html.append("<div class='result-count' id='resultCount'>Showing ").append(allCodes.size()).append(" codes</div>");
    html.append("</div>");
    
    // Table
    html.append("<table id='codesTable'>");
    html.append("<thead><tr>");
    html.append("<th style='width: 80px;'>Code</th>");
    html.append("<th style='width: 200px;'>Chapter</th>");
    html.append("<th style='width: 200px;'>Category</th>");
    html.append("<th style='width: 200px;'>Subcategory</th>");
    html.append("<th style='width: 200px;'>Level 2</th>");
    html.append("<th>Description</th>");
    html.append("</tr></thead>");
    html.append("<tbody>");
    
    for (MappedCode code : allCodes) {
        html.append("<tr>");
        html.append("<td class='code-col'>").append(code.getFormattedCode()).append("</td>");
        html.append("<td class='chapter-col'>").append(code.getChapter() != null ? code.getChapter() : "-").append("</td>");
        html.append("<td class='category-col'>").append(code.getDiseaseCategory() != null ? code.getDiseaseCategory() : "-").append("</td>");
        html.append("<td class='subcat-col'>").append(code.getSubcategory() != null ? code.getSubcategory() : "-").append("</td>");
        html.append("<td class='level2-col'>").append(code.getSubcategoryLevel2() != null ? code.getSubcategoryLevel2() : "-").append("</td>");
        html.append("<td>").append(code.getDescription()).append("</td>");
        html.append("</tr>");
    }
    
    html.append("</tbody></table>");
    
    // JavaScript
    html.append("<script>");
    
    // Filter function
    html.append("function filterTable() {");
    html.append("  var searchInput = document.getElementById('searchBox').value.toLowerCase();");
    html.append("  var table = document.getElementById('codesTable');");
    html.append("  var tr = table.getElementsByTagName('tr');");
    html.append("  var visibleCount = 0;");
    html.append("  for (var i = 1; i < tr.length; i++) {");
    html.append("    var row = tr[i];");
    html.append("    var text = row.textContent.toLowerCase();");
    html.append("    if (text.includes(searchInput)) {");
    html.append("      row.style.display = '';");
    html.append("      visibleCount++;");
    html.append("    } else {");
    html.append("      row.style.display = 'none';");
    html.append("    }");
    html.append("  }");
    html.append("  document.getElementById('resultCount').textContent = 'Showing ' + visibleCount + ' codes';");
    html.append("}");
    
    // CSV Export function
    html.append("function exportCSV() {");
    html.append("  var table = document.getElementById('codesTable');");
    html.append("  var csv = 'Code,Chapter,Category,Subcategory,Level 2,Description\\n';");
    html.append("  var rows = table.getElementsByTagName('tr');");
    html.append("  for (var i = 1; i < rows.length; i++) {");
    html.append("    if (rows[i].style.display !== 'none') {");
    html.append("      var cells = rows[i].cells;");
    html.append("      csv += '\"' + cells[0].textContent + '\",';");
    html.append("      csv += '\"' + cells[1].textContent + '\",';");
    html.append("      csv += '\"' + cells[2].textContent + '\",';");
    html.append("      csv += '\"' + cells[3].textContent + '\",';");
    html.append("      csv += '\"' + cells[4].textContent + '\",';");
    html.append("      csv += '\"' + cells[5].textContent.replace(/\"/g, '\"\"') + '\"\\n';");
    html.append("    }");
    html.append("  }");
    html.append("  var blob = new Blob([csv], { type: 'text/csv' });");
    html.append("  var url = window.URL.createObjectURL(blob);");
    html.append("  var a = document.createElement('a');");
    html.append("  a.href = url;");
    html.append("  a.download = 'icd10_codes_hierarchy.csv';");
    html.append("  document.body.appendChild(a);");
    html.append("  a.click();");
    html.append("  document.body.removeChild(a);");
    html.append("}");
    
    // Excel Export function
    html.append("function exportExcel() {");
    html.append("  window.location.href = '/api/codes/export/excel-hierarchy';");
    html.append("}");
    
    html.append("</script>");
    html.append("</body></html>");
    
    return html.toString();
}

    @GetMapping("/export-global-variables")
    @ResponseBody
    public String exportGlobalVariablesPage() {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html><head>");
        html.append("<title>Export Global Variables</title>");
        html.append("<style>");
        html.append("body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }");
        html.append("h1 { color: #2c3e50; }");
        html.append(".container { background: white; padding: 40px; border-radius: 8px; max-width: 800px; margin: 0 auto; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
        html.append(".info { background: #ecf0f1; padding: 20px; border-radius: 5px; margin: 20px 0; }");
        html.append(".download-btn { padding: 15px 30px; background: #27ae60; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }");
        html.append(".download-btn:hover { background: #229954; }");
        html.append("ul { line-height: 2; }");
        html.append("</style>");
        html.append("</head><body>");
        
        html.append("<div class='container'>");
        html.append("<h1> Export Global Variables</h1>");
        
        html.append("<div class='info'>");
        html.append("<h3>What You'll Get:</h3>");
        html.append("<p>A comprehensive Excel file with <strong>all Global Variables</strong> and their associated codes across all code systems.</p>");
        html.append("<ul>");
        html.append("<li><strong>Sheet 1: Summary</strong> - List of all GVs with code counts</li>");
        html.append("<li><strong>Sheet 2: All Codes</strong> - Every code for every GV</li>");
        html.append("<li><strong>Sheet 3: Unmapped Codes</strong> - Codes without GV assignment (621 ICD-9 codes)</li>");
        html.append("</ul>");
        html.append("<p><strong>Currently includes:</strong> ICD-10-CM codes</p>");
        html.append("<p><em>(ICD-9-CM and SNOMED CT will be added soon!)</em></p>");
        html.append("</div>");
        
        html.append("<button class='download-btn' onclick='downloadExcel()'>📥 Download Complete Excel File</button>");
        
        html.append("<div style='margin-top: 30px; color: #7f8c8d;'>");
        html.append("<p><strong>File includes:</strong></p>");
        html.append("<ul>");
        html.append("<li>All Chapters (21)</li>");
        html.append("<li>All Categories (265+)</li>");
        html.append("<li>All Subcategories (500+)</li>");
        html.append("<li>All Level 2 classifications (1000+)</li>");
        html.append("</ul>");
        html.append("</div>");
        
        html.append("</div>");



        html.append("<script>");
        html.append("function downloadExcel() {");
        html.append("  window.location.href = '/api/codes/export/global-variables';");
        html.append("}");
        html.append("</script>");
        
        html.append("</body></html>");
        
        return html.toString();
    }
    
}

