package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;

public interface StudentGangDisciplineService {
    StudentGangDisciplineEntity create(Long studentGangId, Long disciplineId);
}
