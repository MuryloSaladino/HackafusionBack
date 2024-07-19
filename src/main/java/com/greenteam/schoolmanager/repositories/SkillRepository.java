package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.SkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<SkillEntity, Long> {
}
