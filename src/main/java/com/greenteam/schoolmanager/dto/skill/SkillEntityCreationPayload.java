package com.greenteam.schoolmanager.dto.skill;


import com.greenteam.schoolmanager.entities.SkillEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class SkillEntityCreationPayload {

    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    public SkillEntity toEntity() {
        return new SkillEntity(name);
    }
}
