package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class AnswerEntity extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @ManyToOne() @JoinColumn(nullable = false)
    private QuestionEntity questionId;

    @ManyToOne() @JoinColumn(nullable = false)
    private UserEntity userId;


    public AnswerEntity() {}

    public AnswerEntity(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.update();
        this.description = description;
    }

    public void setQuestion(QuestionEntity questionId) {
        this.update();
        this.questionId = questionId;
    }

    public void setUserId(UserEntity userId) {
        this.update();
        this.userId = userId;
    }
}
