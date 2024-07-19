package com.greenteam.schoolmanager.dto.userSkill;

import com.greenteam.schoolmanager.dto.skill.SkillEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.entities.UserSkillEntity;

public class UserSkillEntityResponse {

    public Long id;
    public Float level;
    public SkillEntityResponse skill;
    public UserEntityResponse user;


    public UserSkillEntityResponse(UserSkillEntity userSkillEntity) {
        this.id = userSkillEntity.getId();
        this.level = userSkillEntity.getLevel();
        this.skill = new SkillEntityResponse(userSkillEntity.getSkill());
        this.user = new UserEntityResponse(userSkillEntity.getUser());
    }
}
