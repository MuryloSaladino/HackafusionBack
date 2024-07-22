package com.greenteam.schoolmanager.dto.question;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class QuestionEntityUpdatePayload {

    private String title;

    private String description;
}
