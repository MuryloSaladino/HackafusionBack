package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.skill.SkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.skill.SkillEntityResponse;
import com.greenteam.schoolmanager.dto.skill.SkillEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.SkillEntityService;
import com.greenteam.schoolmanager.repositories.SkillRepository;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    UserSession userSession;

    @Autowired
    SkillEntityService skillEntityService;

    @PostMapping
    protected ResponseEntity<SkillEntityResponse> createSkill (
            @Valid @RequestBody SkillEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new SkillEntityResponse( skillEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected  ResponseEntity<SkillEntityResponse> updateSkill (
            @Valid @RequestBody SkillEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new SkillEntityResponse( skillEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteSkill (
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        skillEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<SkillEntityResponse>> getAllSkills () {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity.ok(
                skillEntityService
                        .getAll()
                        .stream()
                        .map(SkillEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    protected ResponseEntity<SkillEntityResponse> getSkillById (
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new SkillEntityResponse( skillEntityService.getById(id) ));
    }

}

