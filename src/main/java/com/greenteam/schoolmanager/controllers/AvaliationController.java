package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityResponse;
import com.greenteam.schoolmanager.interfaces.CompetenceAvaliationEntityService;
import com.greenteam.schoolmanager.interfaces.CompetenceEntityService;
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
@RequestMapping("/api/avaliation")
public class AvaliationController {

    @Autowired
    UserSession userSession;

    @Autowired
    CompetenceAvaliationEntityService competenceAvaliationEntityService;

    @Autowired
    DisciplineEntityService disciplineEntityService;

    @Autowired
    CompetenceEntityService competenceEntityService;


    @PostMapping
    protected ResponseEntity<CompetenceAvaliationEntityResponse> createAvaliation(
            @Valid @RequestBody CompetenceAvaliationEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new CompetenceAvaliationEntityResponse( competenceAvaliationEntityService.create(body) ));
    }
}
