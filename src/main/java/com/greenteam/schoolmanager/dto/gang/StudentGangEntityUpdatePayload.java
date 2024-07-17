package com.greenteam.schoolmanager.dto.gang;

import com.greenteam.schoolmanager.enums.DisciplineType;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class StudentGangEntityUpdatePayload {

    @Pattern(regexp = "\\b(TI|MECHATRONIC|ADMINISTRATIVE)\\b")
    private DisciplineType mainDisciplineType;

    @Size(min = 8, max = 100)
    private String name;
}
