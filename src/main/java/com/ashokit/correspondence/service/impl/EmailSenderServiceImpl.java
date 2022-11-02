package com.ashokit.correspondence.service.impl;

import com.amazonaws.util.IOUtils;
import com.ashokit.correspondence.service.EmailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    final JavaMailSender mailSender;

    @Override
    public boolean sendEmail(String to, String subject, String body, ByteArrayInputStream pdf) {
        boolean isMailSent = false;
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(body, true);
            InputStream inputStream = pdf;
            messageHelper.addAttachment(
                    "Application Status.pdf",
                    new ByteArrayResource(IOUtils.toByteArray(inputStream))
            );
            mailSender.send(mimeMessage);
            isMailSent = true;

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return isMailSent;
    }
}
