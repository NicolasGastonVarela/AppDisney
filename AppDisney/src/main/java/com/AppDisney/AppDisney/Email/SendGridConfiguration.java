package com.AppDisney.AppDisney.Email;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridConfiguration {

    @Value("$(sendgrid.key)")
    private String key;

    @Bean
    public SendGrid getSendGrid(){
        return new SendGrid(key);
    }

}
