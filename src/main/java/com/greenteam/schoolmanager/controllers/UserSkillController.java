package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityResponse;
import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.UserSkillEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userSkill")
public class UserSkillController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private UserSkillEntityService userSkillEntityService;


    @PostMapping
    protected ResponseEntity<UserSkillEntityResponse> createUserSkill(
            @Valid @RequestBody UserSkillEntityCreationPayload body
    ) {
        userSession.verifyOwnUserOrAdmin(body.getUserId());

        return ResponseEntity
                .status(201)
                .body(new UserSkillEntityResponse( userSkillEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<UserSkillEntityResponse> updateUserSkill(
            @Valid @RequestBody UserSkillEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyOwnUserOrAdmin(id);

        return ResponseEntity
                .status(200)
                .body(new UserSkillEntityResponse( userSkillEntityService.update(id,body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<UserSkillEntityResponse> deleteUserSkill(
            @PathVariable Long id
    ) {
        userSession.verifyOwnUserOrAdmin(id);

        userSkillEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<UserSkillEntityResponse>> getAllUserSkills() {
        userSession.verifyAdmin();

        return ResponseEntity.ok(
                userSkillEntityService
                        .getAll()
                        .stream()
                        .map(UserSkillEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{userId}")
    protected ResponseEntity<List<UserSkillEntityResponse>> getUserSkillByUserId(
            @PathVariable Long userId
    ) {
        userSession.verifyOwnUserOrAdmin(userId);

        return ResponseEntity.ok(
                userSkillEntityService
                        .getByUserId(userId)
                        .stream()
                        .map(UserSkillEntityResponse::new)
                        .toList()
        );
    }
}
