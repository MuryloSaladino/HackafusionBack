package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGangDisciplineRepository extends CrudRepository<StudentGangDisciplineEntity, Long> {}
