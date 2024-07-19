package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityCreationPayload;
import com.greenteam.schoolmanager.dto.userSkill.UserSkillEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.UserSkillEntity;
import com.greenteam.schoolmanager.exceptions.BadRequestException;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.UserSkillEntityService;
import com.greenteam.schoolmanager.repositories.SkillRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import com.greenteam.schoolmanager.repositories.UserSkillRepository;
import com.greenteam.schoolmanager.sessions.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillEntityServiceDefault implements UserSkillEntityService {

    @Autowired
    UserSession userSession;

    @Autowired
    UserSkillRepository userSkillRepository;

    @Autowired
    SkillRepository skillRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public UserSkillEntity create(UserSkillEntityCreationPayload payload) {

        UserSkillEntity userSkillEntity = payload.toEntity();

        var userQuery = userRepository.findById(payload.getUserId());
        if (userQuery.isEmpty()) throw new NotFoundException("User not found");

        var skillQuery = skillRepository.findById(payload.getSkillId());
        if (skillQuery.isEmpty()) throw new NotFoundException("Skill not found");

        var userSkillQuery = userSkillRepository.findByUserAndSkill(userQuery.get(), skillQuery.get());
        if (!userSkillQuery.isEmpty()) throw new BadRequestException("Skill already exists");

        userSkillEntity.setSkill(skillQuery.get());
        userSkillEntity.setUser(userQuery.get());

        return userSkillRepository.save(userSkillEntity);
    }

    @Override
    public UserSkillEntity update(Long id, UserSkillEntityUpdatePayload payload) {

        var query = userSkillRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Skill not found");

        var entity = query.get();

        if (payload.getLevel() != null) entity.setLevel(payload.getLevel());

        return userSkillRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

        var query = userSkillRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Skill not found");

        userSkillRepository.delete(query.get());
    }

    @Override
    public List<UserSkillEntity> getByUserId(Long userId) {

        var query = userSkillRepository.findByUserId(userId);
        if (query.isEmpty()) throw new NotFoundException("Skill not found");

        return query;
    }

    @Override
    public List<UserSkillEntity> getAll() {
        return (List<UserSkillEntity>) userSkillRepository.findAll();
    }
}
