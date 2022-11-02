package com.ashokit.correspondence.service.impl;

import com.ashokit.correspondence.model.NoticeDetails;
import com.ashokit.correspondence.service.EmailSenderService;
import com.ashokit.correspondence.service.NoticeService;
import com.ashokit.correspondence.service.PdfGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    final PdfGeneratorService pdfGeneratorService;
    final EmailSenderService emailSenderService;

    @Override
    public boolean sendNotice(NoticeDetails noticeDetails) {
        boolean isSent = false;
        try {
            ByteArrayInputStream pdf = pdfGeneratorService.getPdf(noticeDetails);
            emailSenderService.sendEmail(
                    noticeDetails.getCitizenEmail(),
                    noticeDetails.getPlanName() + " Plan Status",
                    "Hi,\nPFA of your " + noticeDetails.getPlanName() + " Plan Status.\nThank You!",
                    pdf
            );
            isSent = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSent;
    }

    @Override
    public NoticeDetails getNoticeDetails(Long caseNo) {
        return NoticeDetails.builder()
                .citizenName("yash chawla")
                .citizenEmail("yashchawla6578@gmail.com")
                .benefitAmt(50000D)
                .denialReason("NA")
                .planName("MediCare")
                .planStatus('S')
                .planStartDate(LocalDate.now())
                .planEndDate(LocalDate.now().plusYears(10))
                .build();
    }
}
