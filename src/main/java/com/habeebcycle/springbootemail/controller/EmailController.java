package com.habeebcycle.springbootemail.controller;

import com.habeebcycle.springbootemail.service.EmailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/sendEmail/{email}")
    public String sendEmail(@PathVariable String email){
        String from = "hcycle.dev2k20@gmail.com";
        String subject = "Test Spring Boot Email Message";
        String message = "Dear User\n\n" + subject + "\nWelcome to our mailing service.\n\nRegards\nHabeeb";
        emailService.sendEmail(email, from, subject, message);
        return "Email sent successfully.";
    }
}
