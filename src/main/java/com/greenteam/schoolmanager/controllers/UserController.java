package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private UserSession userSession;


// =============================================================================================================
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
// =============================================================================================================


    @PostMapping
    protected ResponseEntity<UserEntityResponse> createUserFromCode(
            @Valid @RequestBody UserEntityCreationPayload body,
            @RequestHeader("Authorization") String creationToken
    ) {

        return null;
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<UserEntityResponse> updateUserFromCode(
            @Valid @RequestBody UserEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyOwnUserOrAdmin(id);

        return ResponseEntity
                .status(200)
                .body(new UserEntityResponse( userEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<UserEntityResponse> deleteUserFromCode(
            @PathVariable Long id
    ) {
        userSession.verifyOwnUserOrAdmin(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<UserEntityResponse>> getUserFromCode() {
        userSession.verifyAdmin();

        return ResponseEntity.ok(
                userEntityService
                        .getAll()
                        .stream()
                        .map(UserEntityResponse::new)
                        .toList()
        );
    }
}
