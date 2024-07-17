package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.gang.StudentGangEntityCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.StudentGangEntity;

import java.util.List;

public interface StudentGangEntityService {
    StudentGangEntity create(StudentGangEntityCreationPayload payload);
    StudentGangEntity getById(Long id);
    List<StudentGangEntity> getAll();
    List<StudentGangEntity> getByMainDiscipline(String disciplineName);
    StudentGangEntity update(Long id, StudentGangEntityUpdatePayload payload);
    void delete(Long id);
}
