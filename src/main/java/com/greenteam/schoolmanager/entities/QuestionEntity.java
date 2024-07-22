package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class QuestionEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne() @JoinColumn(nullable = false)
    private UserEntity user;


    public QuestionEntity() {}

    public QuestionEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setTitle(String title) {
        this.update();
        this.title = title;
    }

    public void setDescription(String description) {
        this.update();
        this.description = description;
    }

    public void setUser(UserEntity user) {
        this.update();
        this.user = user;
    }
}
