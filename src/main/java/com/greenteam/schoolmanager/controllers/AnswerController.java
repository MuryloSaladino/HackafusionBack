package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.answer.AnswerEntityCreationPayload;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityResponse;
import com.greenteam.schoolmanager.interfaces.AnswerEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    UserSession userSession;

    @Autowired
    AnswerEntityService answerEntityService;

    @PostMapping
    protected ResponseEntity<AnswerEntityResponse> create(
            @Valid @RequestBody AnswerEntityCreationPayload body
    ) {
        userSession.verifyToken();

        return ResponseEntity
                .status(201)
                .body(new AnswerEntityResponse( answerEntityService.create(body) ));
    }
}
