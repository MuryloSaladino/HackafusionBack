package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.gang.StudentGangEntityCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangEntityResponse;
import com.greenteam.schoolmanager.dto.gang.StudentGangEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.StudentGangEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gang")
public class StudentGangController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private StudentGangEntityService studentGangEntityService;


    @PostMapping
    protected ResponseEntity<StudentGangEntityResponse> createGang(
            @Valid @RequestBody StudentGangEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new StudentGangEntityResponse( studentGangEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<StudentGangEntityResponse> updateGang(
            @Valid @RequestBody StudentGangEntityUpdatePayload body,
            @PathVariable long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new StudentGangEntityResponse( studentGangEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteGang(
            @PathVariable long id
    ) {
        userSession.verifyInstructorOrAdmin();

        studentGangEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<StudentGangEntityResponse>> getGang() {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity.ok(
                studentGangEntityService
                        .getAll()
                        .stream()
                        .map(StudentGangEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    protected ResponseEntity<StudentGangEntityResponse> getGangById(
            @PathVariable long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new StudentGangEntityResponse( studentGangEntityService.getById(id) ));
    }

    @GetMapping("/mainDiscipline/{disciplineName}")
    protected ResponseEntity<List<StudentGangEntityResponse>> getGangByDiscipline(
            @PathVariable String disciplineName
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity.ok(
                studentGangEntityService
                        .getByMainDiscipline(disciplineName)
                        .stream()
                        .map(StudentGangEntityResponse::new)
                        .toList()
        );
    }
}
