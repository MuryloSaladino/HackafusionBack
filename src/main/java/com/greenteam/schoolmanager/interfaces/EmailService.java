package com.greenteam.schoolmanager.interfaces;

public interface EmailService {
    void sendToken(String destination, String token);
}
