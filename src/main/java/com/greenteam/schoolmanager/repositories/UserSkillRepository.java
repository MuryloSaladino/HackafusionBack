package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.UserSkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends CrudRepository<UserSkillEntity, Long> {
}
