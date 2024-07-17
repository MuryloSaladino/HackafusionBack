package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.ResponseMessage;
import com.greenteam.schoolmanager.dto.user.UserCreationCodePayload;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.exceptions.BadRequestException;
import com.greenteam.schoolmanager.interfaces.EmailService;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController @RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private EmailService emailService;

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

    @PostMapping("/sendCode")
    protected ResponseEntity<ResponseMessage> adminCreateUser(
            @Valid @RequestBody UserCreationCodePayload body
    ) {
        userSession.verifyAdmin();

        Map<String, Object> claims = new HashMap<>();
        claims.put("creationRole", body.getRole());

        if(body.getRole().equals(2)) {
            if(body.getStudentGangId() == null) throw new BadRequestException("You need to provide a student gang ID");
            claims.put("studentGangId", body.getStudentGangId());
        }

        String token = jwtTokenManager.buildToken(claims, "admin", userSession.getId());
        emailService.sendToken(body.getEmail(), token);

        return ResponseEntity.ok(new ResponseMessage("Email sent to user"));
    }
}
