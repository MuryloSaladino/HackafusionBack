package com.greenteam.schoolmanager.dto.gang;

import com.greenteam.schoolmanager.entities.StudentGangEntity;
import com.greenteam.schoolmanager.enums.DisciplineType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class StudentGangCreationPayload {

    @Pattern(regexp = "\\b(TI|MECHATRONIC|ADMINISTRATIVE)\\b")
    private String mainDisciplineType;

    @NotNull
    @Size(min = 8, max = 100)
    private String name;


    public StudentGangEntity toEntity() {
        return new StudentGangEntity(DisciplineType.valueOf(mainDisciplineType), name);
    }
}
