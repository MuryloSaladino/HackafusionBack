package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CompetenceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceRepository extends CrudRepository<CompetenceEntity, Long> {
    List<CompetenceEntity> findByDisciplineEntityId(Long disciplineId);
}
