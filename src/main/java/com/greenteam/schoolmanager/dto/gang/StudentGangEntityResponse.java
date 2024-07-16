package com.greenteam.schoolmanager.dto.gang;

import com.greenteam.schoolmanager.entities.StudentGangEntity;

public class StudentGangEntityResponse {

    public String mainDisciplineType;
    public String name;

    public StudentGangEntityResponse(StudentGangEntity studentGangEntity) {
        this.name = studentGangEntity.getName();
        this.mainDisciplineType = studentGangEntity.getMainDisciplineType().toString();
    }
}
