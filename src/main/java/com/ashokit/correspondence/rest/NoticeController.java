package com.ashokit.correspondence.rest;

import com.ashokit.correspondence.model.NoticeDetails;
import com.ashokit.correspondence.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("/trigger")
    void test() {
        NoticeDetails noticeDetails = noticeService.getNoticeDetails(1L);
        noticeService.sendNotice(noticeDetails);
    }
}
