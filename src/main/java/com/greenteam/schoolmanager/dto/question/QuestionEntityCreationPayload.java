package com.greenteam.schoolmanager.dto.question;

import com.greenteam.schoolmanager.entities.QuestionEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class QuestionEntityCreationPayload {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Long userId;

    public QuestionEntity toEntity() {
        return new QuestionEntity(title, description);
    }
}
