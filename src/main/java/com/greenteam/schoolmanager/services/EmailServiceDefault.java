package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceDefault implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendToken(String destination, String token) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(destination);
        message.setSubject("Account Creation for the School System");
        message.setText(
                "<h2>You've received a invite to create a user in our system</h2>" +
                "<a href=\"localhost:5173/signup/"+token+"\">Register</a>"
        );

        mailSender.send(message);
    }
}
