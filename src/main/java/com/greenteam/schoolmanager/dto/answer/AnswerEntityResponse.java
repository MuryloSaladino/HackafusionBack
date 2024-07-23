package com.greenteam.schoolmanager.dto.answer;

import com.greenteam.schoolmanager.dto.question.QuestionEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.AnswerEntity;

public class AnswerEntityResponse {

    public Long id;
    public String description;
    public UserEntityResponse user;

    public AnswerEntityResponse(AnswerEntity answerEntity) {
        this.id = answerEntity.getId();
        this.description = answerEntity.getDescription();
        this.user = new UserEntityResponse(answerEntity.getUser());
    }
}
