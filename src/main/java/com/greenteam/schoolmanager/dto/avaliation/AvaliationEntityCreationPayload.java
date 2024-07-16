package com.greenteam.schoolmanager.dto.avaliation;

import com.greenteam.schoolmanager.entities.AvaliationEntity;
import com.greenteam.schoolmanager.enums.CompetenceLevel;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class AvaliationEntityCreationPayload {

    @NotNull
    @Positive
    private Long userId;

    @NotNull
    @Positive
    private Long disciplineId;


    public AvaliationEntity toEntity() {
        return new AvaliationEntity();
    }
}
