package org.example.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.model.PayBankParkingEntity;
import org.example.repository.PayBankParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {

    @Autowired
    private PayBankParkingRepository payBankParkingRepository;

    public byte[] generatePdf() throws IOException, DocumentException {
        List<PayBankParkingEntity> entities = payBankParkingRepository.findAll();

        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();

        // Create table with 10 columns
        PdfPTable table = new PdfPTable(10);
        table.setWidthPercentage(100); // Make the table full width

        // Add table headers
        table.addCell("Branch Name");
        table.addCell("Policy Number");
        table.addCell("Application No");
        table.addCell("Business Type");
        table.addCell("LA Name");
        table.addCell("Plan Name");
        table.addCell("Premium Amount");
        table.addCell("Payment Mode");
        table.addCell("Ext Ref No");
        table.addCell("COD Drawer Acct");

        // Add data rows
        for (PayBankParkingEntity entity : entities) {
            table.addCell(entity.getBranch_name());
            table.addCell(String.valueOf(entity.getPolicy_number()));
            table.addCell(entity.getApplication_no());
            table.addCell(entity.getBusiness_type());
            table.addCell(entity.getLa_name());
            table.addCell(entity.getPlan_name());
            table.addCell(String.valueOf(entity.getPremium_amount()));
            table.addCell(entity.getPayment_mode());
            table.addCell(String.valueOf(entity.getExt_ref_no()));
            table.addCell(String.valueOf(entity.getCod_drawer_acct()));
        }

        document.add(new Paragraph("Pay Bank Parking Data Report"));
        document.add(new Paragraph(" ")); // Add some space
        document.add(table);

        document.close();
        return baos.toByteArray();
    }
}
