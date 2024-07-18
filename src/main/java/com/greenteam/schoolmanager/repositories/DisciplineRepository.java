package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.DisciplineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends CrudRepository<DisciplineEntity, Long> {}
