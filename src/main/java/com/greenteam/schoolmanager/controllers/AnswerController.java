package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.answer.AnswerEntityCreationPayload;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityResponse;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.AnswerEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    UserSession userSession;

    @Autowired
    AnswerEntityService answerEntityService;

    @PostMapping
    protected ResponseEntity<AnswerEntityResponse> createAnswer(
            @Valid @RequestBody AnswerEntityCreationPayload body
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(201)
                .body(new AnswerEntityResponse( answerEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<AnswerEntityResponse> updateAnswer(
            @Valid @RequestBody AnswerEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(200)
                .body(new AnswerEntityResponse( answerEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteAnswer(
            @PathVariable Long id
    ) {
        userSession.verifyOwnUserOrAdmin(id);

        answerEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<AnswerEntityResponse>> getAllAnswers() {
        userSession.verifyToken();

        return ResponseEntity.ok(
                answerEntityService
                        .getAll()
                        .stream()
                        .map(AnswerEntityResponse::new)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    protected ResponseEntity<List<AnswerEntityResponse>> getAnswerById(
            @PathVariable Long id
    ) {
        userSession.verifyToken();

        return ResponseEntity.ok(
                answerEntityService
                        .getById(id)
                        .stream()
                        .map(AnswerEntityResponse::new)
                        .toList()
        );
    }
}
