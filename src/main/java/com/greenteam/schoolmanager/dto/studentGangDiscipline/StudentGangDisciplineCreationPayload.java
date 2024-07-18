package com.greenteam.schoolmanager.dto.studentGangDiscipline;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class StudentGangDisciplineCreationPayload {

    @NotNull
    @PositiveOrZero
    private Long gangId;

    @NotNull
    @PositiveOrZero
    private Long disciplineId;

    public StudentGangDisciplineEntity toEntity() {
        return new StudentGangDisciplineEntity();
    }
}
