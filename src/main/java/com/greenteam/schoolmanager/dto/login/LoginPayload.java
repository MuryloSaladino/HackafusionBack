package com.greenteam.schoolmanager.dto.login;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class LoginPayload {

    @NotNull
    private String usernameOrEmail;

    @NotNull
    private String password;
}
