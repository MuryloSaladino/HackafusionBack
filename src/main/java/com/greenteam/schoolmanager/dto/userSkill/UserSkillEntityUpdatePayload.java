package com.greenteam.schoolmanager.dto.userSkill;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserSkillEntityUpdatePayload {

    @Min(1) @Max(5)
    private Integer level;
}
