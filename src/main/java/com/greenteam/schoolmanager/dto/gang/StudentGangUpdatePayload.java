package com.greenteam.schoolmanager.dto.gang;

import com.greenteam.schoolmanager.enums.DisciplineType;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class StudentGangUpdatePayload {

    private DisciplineType mainDisciplineType;

    private String name;
}
