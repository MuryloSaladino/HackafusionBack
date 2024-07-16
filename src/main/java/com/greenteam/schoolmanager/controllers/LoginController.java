package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.login.LoginPayload;
import com.greenteam.schoolmanager.dto.login.LoginResponse;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.interfaces.LoginService;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserEntityService userEntityService;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginPayload body) {

        String token = loginService.login(body.getUsernameOrEmail(), body.getPassword());
        UserEntity user = userEntityService.getByUsernameOrEmail(body.getUsernameOrEmail());

        return ResponseEntity.ok(new LoginResponse(token, user));
    }
}
