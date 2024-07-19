package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.SkillEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.entities.UserSkillEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends CrudRepository<UserSkillEntity, Long> {
    List<UserSkillEntity> findByUserId(Long userId);
    List<UserSkillEntity> findByUserAndSkill(UserEntity user, SkillEntity skill);
    List<UserSkillEntity> findBySkill(SkillEntity skill);
}
