package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityResponse;
import com.greenteam.schoolmanager.dto.competence.CompetenceEntityCreationPayload;
import com.greenteam.schoolmanager.dto.competence.CompetenceEntityResponse;
import com.greenteam.schoolmanager.dto.competence.CompetenceEntityUpdatePayload;
import com.greenteam.schoolmanager.dto.student.StudentGradesResponse;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.interfaces.CompetenceEntityService;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competence")
public class CompetenceController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private CompetenceEntityService competenceEntityService;

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping
    protected ResponseEntity<CompetenceEntityResponse> createCompetence(
            @Valid @RequestBody CompetenceEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new CompetenceEntityResponse( competenceEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<CompetenceEntityResponse> updateCompetence(
            @Valid @RequestBody CompetenceEntityUpdatePayload body,
            @PathVariable Long id
    ) {
       userSession.verifyInstructorOrAdmin();

       return ResponseEntity
               .status(200)
               .body(new CompetenceEntityResponse( competenceEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteCompetence(
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        competenceEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/discipline/{disciplineId}")
    protected ResponseEntity<List<CompetenceEntityResponse>> getDiscipline(
            @PathVariable Long disciplineId
    ) {
        userSession.verifyToken();

        return ResponseEntity.ok(
                competenceEntityService
                        .getByDiscipline(disciplineId)
                        .stream()
                        .map(CompetenceEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    protected ResponseEntity<CompetenceEntityResponse> getCompetence(
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(200)
                .body(new CompetenceEntityResponse( competenceEntityService.getById(id) ));
    }

    @GetMapping("/student/{userId}")
    protected ResponseEntity<?> getCompetenceByUser(
            @PathVariable Long userId
    ) {
        userSession.verifyAdminOrInstructorOrOwnUser(userId);

        var user = userEntityService.getById(userId);
        var query = competenceEntityService.getByUserId(userId);

        return ResponseEntity.ok(new StudentGradesResponse(user, query));
    }
}
