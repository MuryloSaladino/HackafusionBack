package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityResponse;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.CompetenceAvaliationEntityService;
import com.greenteam.schoolmanager.interfaces.CompetenceEntityService;
import com.greenteam.schoolmanager.interfaces.DisciplineEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{id}")
    protected ResponseEntity<CompetenceAvaliationEntityResponse> updateAvaliation(
            @Valid @RequestBody CompetenceAvaliationEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new CompetenceAvaliationEntityResponse( competenceAvaliationEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteAvaliation(
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        competenceAvaliationEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
