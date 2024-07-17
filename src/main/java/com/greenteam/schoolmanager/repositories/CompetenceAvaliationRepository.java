package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenceAvaliationRepository extends CrudRepository<CompetenceAvaliationEntity, Long> {
}
