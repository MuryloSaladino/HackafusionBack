package com.greenteam.schoolmanager.dto.competence;

import com.greenteam.schoolmanager.entities.CompetenceEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CompetenceEntityCreationPayload {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    private Float weight;

    @NotNull
    @PositiveOrZero
    private Long disciplineId;

    public CompetenceEntity toEntity() {
        return new CompetenceEntity(name, description, weight);
    }
}
