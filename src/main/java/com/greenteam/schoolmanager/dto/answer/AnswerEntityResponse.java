package com.greenteam.schoolmanager.dto.answer;

import com.greenteam.schoolmanager.dto.question.QuestionEntityResponse;
import com.greenteam.schoolmanager.entities.AnswerEntity;

public class AnswerEntityResponse {

    public Long id;
    public String desciption;
    public QuestionEntityResponse question;

    public AnswerEntityResponse(AnswerEntity answerEntity) {
        this.id = answerEntity.getId();
        this.desciption = answerEntity.getDescription();
        this.question = new QuestionEntityResponse(answerEntity.getQuestion());
    }
}
