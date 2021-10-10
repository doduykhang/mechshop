package com.laptrinhjavaweb.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.service.IEmailSender;

@Service
public class EmailService implements IEmailSender{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(String to, String subject, String email) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");
            helper.setTo(to);
            helper.setText(email);
            helper.setSubject(subject);
            helper.setFrom("dokhang295@gmail.com");
            javaMailSender.send(mimeMessage);
        }catch(MessagingException e){
            throw new IllegalStateException("failed to send email");
        }     
    }
    
}
