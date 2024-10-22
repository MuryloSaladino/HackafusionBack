package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.competence.CompetenceEntityCreationPayload;
import com.greenteam.schoolmanager.dto.competence.CompetenceEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.entities.CompetenceEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.CompetenceEntityService;
import com.greenteam.schoolmanager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetenceEntityServiceDefault implements CompetenceEntityService {

    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AvaliationRepository avaliationRepository;

    @Autowired
    CompetenceAvaliationRepository competenceAvaliationRepository;


    @Override
    public CompetenceEntity create(CompetenceEntityCreationPayload payload) {

        CompetenceEntity competenceEntity = payload.toEntity();

        var query = disciplineRepository.findById(payload.getDisciplineId());
        if(query.isEmpty()) throw new NotFoundException("Discipline not found");

        competenceEntity.setDisciplineEntity(query.get());

        return competenceRepository.save(competenceEntity);
    }

    @Override
    public CompetenceEntity getById(Long id) {

        var query = competenceRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        return query.get();
    }

    @Override
    public List<CompetenceEntity> getByDiscipline(Long disciplineId) {

        return competenceRepository.findByDisciplineEntityId(disciplineId);
    }

    @Override
    public CompetenceEntity update(Long id, CompetenceEntityUpdatePayload payload) {

        var query = competenceRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        var competenceEntity = query.get();

        if(payload.getName() != null) competenceEntity.setName(payload.getName());
        if(payload.getDescription() != null) competenceEntity.setDescription(payload.getDescription());
        if(payload.getWeight() != null) competenceEntity.setWeight(payload.getWeight());

        if(payload.getDisciplineId() != null) {
            var disciplineQuery = disciplineRepository.findById(payload.getDisciplineId());
            if(disciplineQuery.isEmpty()) throw new NotFoundException("Discipline not found");

            competenceEntity.setDisciplineEntity(disciplineQuery.get());
        }

        return competenceRepository.save(competenceEntity);
    }

    @Override
    public void delete(Long id) {

        var query = competenceRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        competenceRepository.delete(query.get());
    }

    @Override
    public List<List<CompetenceAvaliationEntity>> getByUserId(Long userId) {

        var user = userRepository.findById(userId);
        if(user.isEmpty()) throw new NotFoundException("User not found");

        var avaliations = avaliationRepository.findByUser(user.get());

        List<List<CompetenceAvaliationEntity>> competenceAvaliations = new ArrayList<>();

        for(var avaliation : avaliations) {
            competenceAvaliations.add(competenceAvaliationRepository.findByAvaliationEntity(avaliation));
        }

        return competenceAvaliations;
    }
}
