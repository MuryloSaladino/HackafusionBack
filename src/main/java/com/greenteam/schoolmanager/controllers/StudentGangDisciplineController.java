package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.studentGangDiscipline.StudentGangDisciplineCreationPayload;
import com.greenteam.schoolmanager.dto.studentGangDiscipline.StudentGangDisciplineResponse;
import com.greenteam.schoolmanager.interfaces.StudentGangDisciplineEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/studentDiscipline")
public class StudentGangDisciplineController {

    @Autowired
    UserSession userSession;

    @Autowired
    StudentGangDisciplineEntityService studentGangDisciplineEntityService;

    @PostMapping
    protected ResponseEntity<StudentGangDisciplineResponse> create(
            @Valid @RequestBody StudentGangDisciplineCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new StudentGangDisciplineResponse( studentGangDisciplineEntityService.create(body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<StudentGangDisciplineResponse> delete(
        @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        studentGangDisciplineEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
