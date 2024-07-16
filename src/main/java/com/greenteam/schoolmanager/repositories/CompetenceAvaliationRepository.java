package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceAvaliationRepository extends JpaRepository<CompetenceAvaliationEntity, Long> {
}
