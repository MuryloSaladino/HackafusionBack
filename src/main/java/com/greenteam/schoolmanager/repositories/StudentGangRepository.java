package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.StudentGangEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentGangRepository extends CrudRepository<StudentGangEntity, Long> {}
