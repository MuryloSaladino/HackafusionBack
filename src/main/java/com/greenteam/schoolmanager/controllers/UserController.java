package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping
    protected ResponseEntity<UserEntityResponse> createUserFromCode(
            @Valid @RequestBody UserEntityCreationPayload body,
            @RequestHeader("Authorization") String creationToken
    ) {

        return null;
    }

    
}
