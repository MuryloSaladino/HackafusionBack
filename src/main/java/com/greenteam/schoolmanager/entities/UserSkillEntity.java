package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class UserSkillEntity extends BaseEntity {

    @Column(nullable = false)
    private Integer level;

    @ManyToOne @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne @JoinColumn(nullable = false)
    private SkillEntity skill;

    public void setLevel(Integer level) {
        this.update();
        this.level = level;
    }

    public void setUser(UserEntity user) {
        this.update();
        this.user = user;
    }

    public void setSkill(SkillEntity skill) {
        this.update();
        this.skill = skill;
    }
}
