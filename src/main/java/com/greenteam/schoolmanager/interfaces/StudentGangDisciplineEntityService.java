package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.studentGangDiscipline.StudentGangDisciplineCreationPayload;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangEntity;

import java.util.List;

public interface StudentGangDisciplineEntityService {
    StudentGangDisciplineEntity create(StudentGangDisciplineCreationPayload payload);
    List<DisciplineEntity> findByGangNotContaining(Long gang);
    void delete(Long id);
}
