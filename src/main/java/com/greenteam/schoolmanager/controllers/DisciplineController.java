package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityCreationPayload;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityResponse;
import com.greenteam.schoolmanager.interfaces.DisciplineEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/discipline")
public class DisciplineController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private DisciplineEntityService disciplineEntityService;

    @PostMapping
    protected ResponseEntity<DisciplineEntityResponse> createDiscipline(
            @Valid @RequestBody DisciplineEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity.status(201).body(new DisciplineEntityResponse(disciplineEntityService.create(body)));
    }
}
