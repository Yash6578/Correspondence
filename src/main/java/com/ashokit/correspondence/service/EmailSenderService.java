package com.ashokit.correspondence.service;

import java.io.ByteArrayInputStream;

public interface EmailSenderService {
    boolean sendEmail(String to, String subject, String body, ByteArrayInputStream pdf);
}
