package org.example.controller;

import org.example.service.ExcelService;
import org.example.service.ParkingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@RestController
public class ExcelController {
    @Autowired
    ExcelService excelService;
    @Autowired
    ParkingDataService parkingDataService;


    @PostMapping("/upload")
    public ResponseEntity<Map<String, String>> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            Map<String, String> response = excelService.kimportExcelData(file);
            // Return ResponseEntity based on the response map's status
            if ("200".equals(response.get("statusCode"))) {
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            } else {
                // Map indicates an error, return internal server error
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (IOException e) {
            Map<String, String> response = Map.of("statusMessage", "Failed to process file: " + e.getMessage(), "statusCode", "500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/getParkingData")
    public ResponseEntity<Map<String, Object>> getParkingData(@RequestParam("applicatinNo") String applicationNo) {

        Map<String, Object> response = parkingDataService.getParkingData(applicationNo);
        if (response.containsValue("200")) {
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }
}