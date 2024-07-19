package com.greenteam.schoolmanager.dto.question;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class QuestionEntityUpdatePayload {

    @NotNull
    private String title;

    @NotNull
    private String description;
}
