package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.ResponseMessage;
import com.greenteam.schoolmanager.dto.register.PreRegisterPayload;
import com.greenteam.schoolmanager.dto.register.PreRegisterResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.interfaces.PreRegisterService;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private PreRegisterService preRegisterService;

    @Autowired
    private UserEntityService userEntityService;


    @PostMapping("/pre")
    protected ResponseEntity<ResponseMessage> preRegister(@Valid @RequestBody PreRegisterPayload body) {
        userSession.verifyAdmin();

        preRegisterService.createPreRegister(body);
        return ResponseEntity.ok(new ResponseMessage("Email registered successfully"));
    }

    @GetMapping("/{email}")
    protected ResponseEntity<PreRegisterResponse> getRegister(@PathVariable String email) {
        return ResponseEntity.ok(new PreRegisterResponse( preRegisterService.getByEmail(email) ));
    }

    @PostMapping
    protected ResponseEntity<UserEntityResponse> createUserFromPreRegister(
            @Valid @RequestBody UserEntityCreationPayload body
    ) {
        return ResponseEntity.ok(new UserEntityResponse( preRegisterService.createFromPreRegister(body) ));
    }
}
