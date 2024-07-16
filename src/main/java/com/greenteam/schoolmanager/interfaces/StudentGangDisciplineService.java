package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;

import java.util.List;

public interface StudentGangDisciplineService {
    StudentGangDisciplineEntity create(Long studentId, Long studentGangDisciplineId);
    StudentGangDisciplineEntity getById(Long id);
    List<StudentGangDisciplineEntity> getAll();
    StudentGangDisciplineEntity update();
    void delete(Long id);
}
