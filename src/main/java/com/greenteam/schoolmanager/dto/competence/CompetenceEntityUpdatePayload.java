package com.greenteam.schoolmanager.dto.competence;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CompetenceEntityUpdatePayload {
    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    private Float weight;

    @NotNull
    @Positive
    private Long disciplineId;
}
