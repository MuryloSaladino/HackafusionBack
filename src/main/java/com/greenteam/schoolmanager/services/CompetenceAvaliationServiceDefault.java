package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.AvaliationEntity;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.enums.CompetenceLevel;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.CompetenceAvaliationEntityService;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceAvaliationServiceDefault implements CompetenceAvaliationEntityService {

    @Autowired
    private CompetenceAvaliationRepository competenceAvaliationRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private AvaliationRepository avaliationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;


    @Override
    public CompetenceAvaliationEntity create(CompetenceAvaliationEntityCreationPayload payload) {

        CompetenceAvaliationEntity entity = payload.toEntity();

        var competenceQuery = competenceRepository.findById(payload.getCompetenceId());
        if(competenceQuery.isEmpty()) throw new NotFoundException("Competence not found");


        var disciplineQuery = disciplineRepository.findById(competenceQuery.get().getDisciplineEntity().getId());
        if(disciplineQuery.isEmpty()) throw new NotFoundException("Discipline not found");

        var userQuery = userRepository.findById(payload.getUserId());
        if(userQuery.isEmpty()) throw new NotFoundException("User not found");


        var newAvaliation = new AvaliationEntity();
        newAvaliation.setDiscipline(disciplineQuery.get());
        newAvaliation.setUser(userQuery.get());

        newAvaliation = avaliationRepository.save(newAvaliation);

        entity.setStatus(CompetenceLevel.valueOf(payload.getCompetence()));
        entity.setCompetence(competenceQuery.get());
        entity.setAvaliationEntity(newAvaliation);

        return competenceAvaliationRepository.save(entity);
    }

    @Override
    public CompetenceAvaliationEntity getById(Long id) {

        var query = competenceAvaliationRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        return query.get();
    }

    @Override
    public CompetenceAvaliationEntity update(Long id, CompetenceAvaliationEntityUpdatePayload payload) {

        var query = competenceAvaliationRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        var entity = query.get();

        if(payload.getStatus() != null) entity.setStatus(CompetenceLevel.valueOf(payload.getStatus()));

        if(payload.getCompetenceEntityId() != null) {

            var q = competenceRepository.findById((payload.getCompetenceEntityId()));
            if(q.isEmpty()) throw new NotFoundException("Competence not found");

            entity.setCompetence(q.get());
        }

        if(payload.getAvaliationEntityId() != null) {

            var q = avaliationRepository.findById((payload.getAvaliationEntityId()));
            if(q.isEmpty()) throw new NotFoundException("Avaliation not found");

            entity.setAvaliationEntity(q.get());
        }

        return competenceAvaliationRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

        var query = competenceAvaliationRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException("Competence not found");

        competenceAvaliationRepository.delete(query.get());
    }
}
