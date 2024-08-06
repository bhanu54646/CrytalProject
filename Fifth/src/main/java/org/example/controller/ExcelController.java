package org.example.controller;

import org.example.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class ExcelController {
    @Autowired
    ExcelService excelService;


    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = null;
        try {
            response = excelService.kimportExcelData(file);
            // Return ResponseEntity based on the response map's status
            if ("200".equals(response.get("statusCode"))) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                // Map indicates an error, return internal server error
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}