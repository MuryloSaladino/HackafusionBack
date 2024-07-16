package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.DisciplineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<DisciplineEntity, Long> {
}
