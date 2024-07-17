package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityCreationPayload;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityResponse;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.DisciplineEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        return ResponseEntity
                .status(201)
                .body(new DisciplineEntityResponse( disciplineEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<DisciplineEntityResponse> updateDiscipline(
            @Valid @RequestBody DisciplineEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new DisciplineEntityResponse( disciplineEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteDiscipline(
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        disciplineEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<DisciplineEntityResponse>> getDiscipline() {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity.ok(
                disciplineEntityService
                        .getAll()
                        .stream()
                        .map(DisciplineEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    protected ResponseEntity<DisciplineEntityResponse> getDisciplineById(
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(200)
                .body(new DisciplineEntityResponse( disciplineEntityService.getById(id) ));
    }

    @GetMapping("/gang/{id}")
    protected ResponseEntity<List<DisciplineEntityResponse>> getDisciplineByGangId(
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity.ok(
                disciplineEntityService
                        .getByGang(id)
                        .stream()
                        .map(DisciplineEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/student/{id}")
    protected ResponseEntity<List<DisciplineEntityResponse>> getDisciplineByStudentId(
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity.ok(
                disciplineEntityService
                        .getByStudent(id)
                        .stream()
                        .map(DisciplineEntityResponse::new)
                        .toList()
        );
    }
}
