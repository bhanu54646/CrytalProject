package org.example.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.example.model.PayBankParkingEntity;
import org.example.repository.PayBankParkingRepository;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.example.constants.ExcelConstants; // Import the constants class

import java.util.List;
import java.util.Map;

@Service
public class ExcelService {

    @Autowired
    private PayBankParkingRepository payBankParkingRepository;

    public Map<String,String> kimportExcelData(MultipartFile file) throws IOException {
        Map<String,String> map=new HashMap<>();
        long startTime = Instant.now().getEpochSecond();
        System.out.println("Start Time: " + startTime);
        String filename = file.getOriginalFilename();

        if (filename == null || (!filename.endsWith(".xls") && !filename.endsWith(".xlsx"))) {

            map.put("statusMessage","Invalid file type. Please upload an .xls or .xlsx file.");
            map.put("statusCode","500");
            return map;
           // throw new IllegalArgumentException("Invalid file type. Please upload an .xls or .xlsx file.");
        }

        try (InputStream is = file.getInputStream(); Workbook workbook = createWorkbook(is, filename)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Verify headers
            if (rows.hasNext()) {
                Row headerRow = rows.next();
                if (!verifyHeaders(headerRow)) {
                    map.put("statusMessage","Invalid header row. Please ensure the headers match the expected format");
                    map.put("statusCode","500");
                    return map;
                   // throw new IllegalArgumentException("Invalid header row. Please ensure the headers match the expected format.");
                }
            }
            while (rows.hasNext()) {
                Row row = rows.next();
                PayBankParkingEntity dataEntity = new PayBankParkingEntity();

                dataEntity.setBranch_name(getCellValueAsString(row.getCell(0)));
                dataEntity.setPolicy_number(getCellValueAsString(row.getCell(1)));
                dataEntity.setApplication_no(getCellValueAsString(row.getCell(2)));
                dataEntity.setBusiness_type(getCellValueAsString(row.getCell(3)));
                dataEntity.setLa_name(getCellValueAsString(row.getCell(4)));
                dataEntity.setPlan_name(getCellValueAsString(row.getCell(5)));
                dataEntity.setPremium_amount(getCellValueAsString(row.getCell(6)));
                dataEntity.setPayment_mode(getCellValueAsString(row.getCell(7)));
                dataEntity.setExt_ref_no(getCellValueAsString(row.getCell(8)));
                dataEntity.setCod_drawer_acct(getCellValueAsString(row.getCell(9)));
                payBankParkingRepository.save(dataEntity);
            }
        }

        long endTime = Instant.now().getEpochSecond();
        System.out.println("End Time: " + endTime);
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime);

        map.put("statusMessage","FileUploadedSuccessfully");
        map.put("statusCode","200");
        return map;
    }

    private boolean verifyHeaders(Row headerRow) {
        List<String> expectedHeaders = ExcelConstants.EXPECTED_HEADERS;
        for (int i = 0; i < expectedHeaders.size(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell == null || !expectedHeaders.get(i).equalsIgnoreCase(cell.getStringCellValue().trim())) {
                return false;
            }
        }
        return true;
    }

    private Workbook createWorkbook(InputStream is, String filename) throws IOException {
        if (filename.endsWith(".xlsx")) {
            return new XSSFWorkbook(is);
        } else if (filename.endsWith(".xls")) {
            return new HSSFWorkbook(is);
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + filename);
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                Cell evaluatedCell = evaluator.evaluateInCell(cell);
                return getCellValueAsString(evaluatedCell);
            default:
                return "";
        }
    }
}



