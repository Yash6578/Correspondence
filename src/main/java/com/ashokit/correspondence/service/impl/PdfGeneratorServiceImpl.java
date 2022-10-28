package com.ashokit.correspondence.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.ashokit.correspondence.model.NoticeDetails;
import com.ashokit.correspondence.service.PdfGeneratorService;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGeneratorServiceImpl implements PdfGeneratorService {

	@Override
	public ByteArrayInputStream getPdf(NoticeDetails noticeDetails) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, out);

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("Plan Eligibility Details", fontTitle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {5.0f, 10.0f});
        table.setSpacingBefore(10);

        setData(table, noticeDetails);

        document.add(table);
        document.close();

        return new ByteArrayInputStream(out.toByteArray());
	}

    void setData(PdfPTable table, NoticeDetails noticeDetails) {
    	table.addCell("Citizen Name");
		table.addCell(noticeDetails.getCitizenName());
		
		table.addCell("Plan Name");
		table.addCell(noticeDetails.getPlanName());
		
		table.addCell("Plan Status");
		table.addCell(noticeDetails.getPlanStatus().toString());
		
		table.addCell("Plan Start Date");
		table.addCell(noticeDetails.getPlanStartDate().toString());
		
		table.addCell("Plan End Date");
		table.addCell(noticeDetails.getPlanEndDate().toString());
		
		table.addCell("Benefit Amount");
		table.addCell(noticeDetails.getBenefitAmt().toString());
		
		table.addCell("Denial Reason");
		table.addCell(noticeDetails.getDenialReason());
    }
    
}
