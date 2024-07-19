package com.greenteam.schoolmanager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Table @Entity @Getter
public class SkillEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;


    public SkillEntity() {}

    public SkillEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.update();
        this.name = name;
    }
}
