package org.example.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSchedular {

    private final EmailService emailService;

    public EmailSchedular(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 * * * * *")
    public void sendScheduledEmail() {
        emailService.sendEmail(
                "akshay.sharma@lumiq.ai",
                "Scheduled Email",
                "This is a scheduled email sent at a specific interval."
        );
    }
}