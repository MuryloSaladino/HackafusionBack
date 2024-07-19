package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.question.QuestionEntityCreationPayload;
import com.greenteam.schoolmanager.dto.question.QuestionEntityResponse;
import com.greenteam.schoolmanager.dto.question.QuestionEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.QuestionEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.QuestionEntityService;
import com.greenteam.schoolmanager.repositories.QuestionRepository;
import com.greenteam.schoolmanager.sessions.UserSession;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    UserSession userSession;

    @Autowired
    QuestionEntityService questionEntityService;

    @Autowired
    QuestionRepository questionRepository;


    @PostMapping
    protected ResponseEntity<QuestionEntityResponse> createQuestion(
            @Valid @RequestBody QuestionEntityCreationPayload body
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(201)
                .body(new QuestionEntityResponse( questionEntityService.create(body) ));
    }

    @PatchMapping
    protected ResponseEntity<QuestionEntityResponse> updateQuestion(
            @Valid @RequestBody QuestionEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        var userId = questionRepository.findById(id).get().getUser().getId();
        if (userId == null) throw new NotFoundException();

        userSession.verifyOwnUser(userId);

        return ResponseEntity
                .status(200)
                .body(new QuestionEntityResponse( questionEntityService.update(id, body) ));
    }

    @DeleteMapping
    protected ResponseEntity<QuestionEntityResponse> deleteQuestion(
            @PathVariable Long id
    ) {
        var userId = questionRepository.findById(id).get().getUser().getId();
        if (userId == null) throw new NotFoundException();

        userSession.verifyOwnUser(userId);

        questionEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    protected ResponseEntity<List<QuestionEntityResponse>> getAllQuestion() {
        userSession.verifyToken();

        return ResponseEntity.ok(
                questionEntityService.getAll()
                        .stream()
                        .map(QuestionEntityResponse::new)
                        .toList()
        );

    }
}
