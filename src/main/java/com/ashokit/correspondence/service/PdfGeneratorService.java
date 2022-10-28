package com.ashokit.correspondence.service;

import java.io.ByteArrayInputStream;

import com.ashokit.correspondence.model.NoticeDetails;

public interface PdfGeneratorService {
	ByteArrayInputStream getPdf(NoticeDetails noticeDetails);
}
