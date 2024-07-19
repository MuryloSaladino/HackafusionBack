package com.greenteam.schoolmanager.dto.answer;

import com.greenteam.schoolmanager.entities.AnswerEntity;
import com.greenteam.schoolmanager.entities.QuestionEntity;

public class AnswerEntityResponse {

    public Long id;
    public String desciption;
//    public QuestionEntity question;

    public AnswerEntityResponse(AnswerEntity answerEntity) {
        this.id = answerEntity.getId();
        this.desciption = answerEntity.getDescription();
//        this.question = new QuestionEntity(answerEntity.getQuestionId());
    }
}
