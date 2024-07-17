package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.gang.StudentGangCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangUpdatePayload;
import com.greenteam.schoolmanager.entities.StudentGangEntity;

import java.util.List;

public interface StudentGangService {
    StudentGangEntity create(StudentGangCreationPayload payload);
    StudentGangEntity getById(Long id);
    List<StudentGangEntity> getAll();
    List<StudentGangEntity> getByMainDiscipline(String disciplineName);
    StudentGangEntity update(Long id, StudentGangUpdatePayload payload);
    void delete(Long id);
}
