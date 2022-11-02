package com.ashokit.correspondence.sqs;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfiguration {

    @SqsListener("CO_TRIGGERS")
    public void loadMessagesFromQueue(String caseNo) {
        System.out.println("Queue Messages: " + caseNo);
    }
}
