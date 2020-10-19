package com.mayanna.snsclouddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SnsService {

    NotificationMessagingTemplate notificationMessagingTemplate;

    @Autowired
    public SnsService(NotificationMessagingTemplate notificationMessagingTemplate) {
        this.notificationMessagingTemplate = notificationMessagingTemplate;
    }

    public void send(String subject, String message) {
        this.notificationMessagingTemplate.sendNotification("testTopic", message, subject);
    }
}
