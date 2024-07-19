package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.skill.SkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.skill.SkillEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.SkillEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.SkillEntityService;
import com.greenteam.schoolmanager.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillEntityServiceDefault implements SkillEntityService {

    @Autowired
    SkillRepository skillRepository;

    @Override
    public SkillEntity create(SkillEntityCreationPayload payload) {
        return skillRepository.save(payload.toEntity());
    }

    @Override
    public void delete(Long id) {
        var query = skillRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException();

        skillRepository.delete(query.get());
    }

    @Override
    public SkillEntity getById(Long id) {
        var query = skillRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<SkillEntity> getAll() {
        return (List<SkillEntity>) skillRepository.findAll();
    }

    @Override
    public SkillEntity update(Long id, SkillEntityUpdatePayload payload) {
        var query = skillRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException();

        var skill = query.get();

        if (payload.getName() != null) skill.setName(payload.getName());

        return skillRepository.save(skill);
    }
}
