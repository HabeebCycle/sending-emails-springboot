package com.habeebcycle.springbootemail.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender jms) {
        mailSender = jms;
    }

    public void sendEmail(String to, String from, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }

    public void sendMessageWithAttachment(String to, String from, String subject, String message, String attachmentPath)
        throws MessagingException {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailHelper = new MimeMessageHelper(mailMessage, true);

        mailHelper.setTo(to);
        mailHelper.setFrom(from);
        mailHelper.setSubject(subject);
        mailHelper.setText(message, true);

        FileSystemResource file = new FileSystemResource(new File(attachmentPath));
        mailHelper.addAttachment("Attachment File", file);

        mailSender.send(mailMessage);
    }

    public void sendEmailTemplate(String to, String from, String subject, String emailTemplate, String... args){
        String message = String.format(emailTemplate, args);
        sendEmail(to, from, subject, message);
    }
}
