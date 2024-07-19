package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.skill.SkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.skill.SkillEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.SkillEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillEntityService {
    SkillEntity create(SkillEntityCreationPayload payload);
    void delete(Long id);
    SkillEntity getById(Long id);
    List<SkillEntity> getAll();
    SkillEntity update(Long id, SkillEntityUpdatePayload payload);
}