package com.mayanna.snsclouddemo.configuration;

import com.amazonaws.services.sns.AmazonSNS;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfiguration {

    NotificationMessagingTemplate notificationMessagingTemplate;

    @Bean
    public NotificationMessagingTemplate getNotificationMessagingTemplate(AmazonSNS amazonSns) {
        return notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSns);
    }


}

