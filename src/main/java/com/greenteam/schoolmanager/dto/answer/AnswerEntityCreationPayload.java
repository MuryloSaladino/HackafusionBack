package com.greenteam.schoolmanager.dto.answer;

import com.greenteam.schoolmanager.entities.AnswerEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class AnswerEntityCreationPayload {

    @NotNull
    private String description;

    @NotNull
    @PositiveOrZero
    private Long questionId;

    @NotNull
    @PositiveOrZero
    private Long userId;

    public AnswerEntity toEntity() { return new AnswerEntity(description); }
}
