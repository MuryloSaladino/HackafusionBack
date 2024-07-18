package com.greenteam.schoolmanager.dto.studentGangDiscipline;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;

public class StudentGangDisciplineResponse {

    public Long id;

    public StudentGangDisciplineResponse(StudentGangDisciplineEntity entity) {
        this.id = entity.getId();
    }
}
