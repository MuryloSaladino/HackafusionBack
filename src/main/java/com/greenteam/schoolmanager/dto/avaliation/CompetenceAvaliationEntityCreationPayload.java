package com.greenteam.schoolmanager.dto.avaliation;

import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class CompetenceAvaliationEntityCreationPayload {
    @NotNull
    @Pattern(regexp = "\\b(QUALIFIED|UNQUALIFIED|LEARNING)\\b")
    private String competence;
    
    @NotNull
    @PositiveOrZero
    private Long competenceId;
    
//    @NotNull
//    @PositiveOrZero
//    private Long avaliationId;

    @NotNull
    private Long userId;

    public CompetenceAvaliationEntity toEntity() {
        return new CompetenceAvaliationEntity();
    }
}
