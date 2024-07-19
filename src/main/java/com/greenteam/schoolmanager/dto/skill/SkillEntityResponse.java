package com.greenteam.schoolmanager.dto.skill;


import com.greenteam.schoolmanager.entities.SkillEntity;

public class SkillEntityResponse {

    public Long id;
    public String name;

    public SkillEntityResponse(SkillEntity skillEntity) {
        this.id = skillEntity.getId();
        this.name = skillEntity.getName();
    }
}
