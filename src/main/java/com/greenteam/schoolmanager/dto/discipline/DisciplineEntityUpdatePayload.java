package com.greenteam.schoolmanager.dto.discipline;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class DisciplineEntityUpdatePayload {

    @Size(min = 8, max = 50)
    private String name;

    @Size(max = 200)
    private String description;

    @Positive
    private Float workload;

    @Pattern(regexp = "\\b(TI|MECHATRONIC|ADMINISTRATIVE)\\b")
    private String type;
}
