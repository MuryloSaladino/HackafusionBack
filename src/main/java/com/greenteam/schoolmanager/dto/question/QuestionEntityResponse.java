package com.greenteam.schoolmanager.dto.question;

import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.QuestionEntity;

public class QuestionEntityResponse {

    public Long questionId;
    public String title;
    public String description;
    public UserEntityResponse user;

    public QuestionEntityResponse(QuestionEntity questionEntity) {
        this.questionId = questionEntity.getId();
        this.title = questionEntity.getTitle();
        this.description = questionEntity.getDescription();
        this.user = new UserEntityResponse(questionEntity.getUser());
    }
}
