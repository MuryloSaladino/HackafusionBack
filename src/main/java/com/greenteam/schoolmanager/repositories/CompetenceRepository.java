package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CompetenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceEntity, Long> {
}
