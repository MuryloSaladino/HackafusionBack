package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.StudentGangEntity;
import com.greenteam.schoolmanager.enums.DisciplineType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGangRepository extends CrudRepository<StudentGangEntity, Long> {
    List<StudentGangEntity> findByMainDisciplineType(DisciplineType mainDisciplineType);
}
