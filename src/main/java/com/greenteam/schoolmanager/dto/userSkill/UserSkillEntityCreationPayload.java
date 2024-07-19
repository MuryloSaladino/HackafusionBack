package com.greenteam.schoolmanager.dto.userSkill;

import com.greenteam.schoolmanager.entities.UserSkillEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserSkillEntityCreationPayload {

    @NotNull
    @Min(1) @Max(5)
    private Float level;

    @NotNull
    @PositiveOrZero
    private Long skillId;

    @NotNull
    @PositiveOrZero
    private Long userId;


    public UserSkillEntity toEntity() {
        return new UserSkillEntity(level);
    }
}
