package com.greenteam.schoolmanager.dto.discipline;

import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.enums.DisciplineType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class DisciplineEntityCreationPayload {

    @NotNull
    @Size(min = 8, max = 50)
    private String name;

    @Size(max = 200)
    private String description;

    @NotNull
    @Positive
    private Float workload;

    @NotNull
    @Pattern(regexp = "\\b(TI|MECHATRONIC|ADMINISTRATIVE)\\b")
    private String type;

    public DisciplineEntity toEntity() {
        return new DisciplineEntity(name, description, workload, DisciplineType.valueOf(type));
    }
}
