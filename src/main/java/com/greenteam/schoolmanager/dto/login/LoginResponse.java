package com.greenteam.schoolmanager.dto.login;

import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.UserEntity;

public class LoginResponse {

    public String token;
    public UserEntityResponse user;

    public LoginResponse(String token, UserEntity user) {
        this.token = token;
        this.user = new UserEntityResponse(user);
    }
}
