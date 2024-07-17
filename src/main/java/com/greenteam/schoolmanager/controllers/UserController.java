package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserSession userSession;

    @Autowired
    private JwtTokenManager jwtTokenManager;


    @GetMapping("/admincreate")
    protected ResponseEntity<UserEntityResponse> getAdminUser() {
        try {
            return ResponseEntity.ok(new UserEntityResponse(userEntityService.getByUsernameOrEmail("admin")));
        }
        catch (RuntimeException e) {
            var payload = new UserEntityCreationPayload();
            payload.setUsername("admin");
            payload.setPassword("123456");
            payload.setEmail("admin@mail.com");
            payload.setFullname("admin monstro");
            payload.setRole(0);
            return ResponseEntity.status(201).body(new UserEntityResponse(userEntityService.create(payload)));
        }
    }


    @PostMapping
    protected ResponseEntity<UserEntityResponse> createUserFromCode(
            @Valid @RequestBody UserEntityCreationPayload body,
            @RequestHeader("Authorization") String creationToken
    ) {

        return null;
    }

}
