package com.ashokit.correspondence.service;

import com.ashokit.correspondence.model.NoticeDetails;

public interface NoticeService {
    boolean sendNotice(NoticeDetails noticeDetails);

    NoticeDetails getNoticeDetails(Long caseNo);
}
