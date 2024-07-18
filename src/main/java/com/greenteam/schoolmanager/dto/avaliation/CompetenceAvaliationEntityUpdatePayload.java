package com.greenteam.schoolmanager.dto.avaliation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CompetenceAvaliationEntityUpdatePayload {

    @NotNull
    @Pattern(regexp = "\\b(QUALIFIED|UNQUALIFIED|LEARNING)\\b")
    private String competence;

    @PositiveOrZero
    private Long competenceId;

    @PositiveOrZero
    private Long userId;
}
