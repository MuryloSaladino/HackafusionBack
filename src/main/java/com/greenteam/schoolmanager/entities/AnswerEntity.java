package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class AnswerEntity extends BaseEntity {

    @Column(nullable = false)
    private String description;

    @ManyToOne() @JoinColumn(nullable = false)
    private QuestionEntity question;

    @ManyToOne() @JoinColumn(nullable = false)
    private UserEntity user;


    public AnswerEntity() {}

    public AnswerEntity(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.update();
        this.description = description;
    }

    public void setQuestion(QuestionEntity question) {
        this.update();
        this.question = question;
    }

    public void setUser(UserEntity user) {
        this.update();
        this.user = user;
    }
}
