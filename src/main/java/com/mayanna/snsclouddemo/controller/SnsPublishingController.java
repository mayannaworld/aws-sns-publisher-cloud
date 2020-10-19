package com.mayanna.snsclouddemo.controller;

import com.mayanna.snsclouddemo.service.SnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class SnsPublishingController {

    SnsService snsService;

    @Autowired
    public SnsPublishingController(SnsService snsService) {
        this.snsService = snsService;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestParam String subject, @RequestBody String message) {
        try {
            snsService.send(subject, message);
        } catch (Exception e) {
            return "Failed with Exception e: " + e.getMessage();
        }
        return "Success";
    }

}


