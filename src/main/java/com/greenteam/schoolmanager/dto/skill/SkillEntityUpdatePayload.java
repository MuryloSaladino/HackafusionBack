package com.greenteam.schoolmanager.dto.skill;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class SkillEntityUpdatePayload {

    @Size(min = 4, max = 50)
    private String name;
}
