package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.UserSkillEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserSkillEntityService {
    UserSkillEntity create(UserSkillEntityCreationPayload payload);
    UserSkillEntity update(Long id, UserSkillEntityUpdatePayload payload);
    void delete(Long id);
    List<UserSkillEntity> getByUserId(Long id);
    List<UserSkillEntity> getAll();
}
