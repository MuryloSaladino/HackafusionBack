package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.enums.CompetenceLevel;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.CompetenceAvaliationEntityService;
import com.greenteam.schoolmanager.repositories.AvaliationRepository;
import com.greenteam.schoolmanager.repositories.CompetenceAvaliationRepository;
import com.greenteam.schoolmanager.repositories.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceAvaliationServiceDefault implements CompetenceAvaliationEntityService {

    @Autowired
    CompetenceAvaliationRepository competenceAvaliationRepository;

    @Autowired
    CompetenceRepository competenceRepository;

    @Autowired
    AvaliationRepository avaliationRepository;


    @Override
    public CompetenceAvaliationEntity create(CompetenceAvaliationEntityCreationPayload payload) {
        CompetenceAvaliationEntity entity = payload.toEntity();

        var competenceQuery = competenceRepository.findById(payload.getCompetenceId());
        var avaliationQuery = avaliationRepository.findById(payload.getAvaliationId());

        if (competenceQuery.isEmpty()) throw new NotFoundException("Competence not found");
        if (avaliationQuery.isEmpty()) throw new NotFoundException("Avaliation not found");

        entity.setCompetence(competenceQuery.get());
        entity.setAvaliationEntity(avaliationQuery.get());

        return competenceAvaliationRepository.save(entity);
    }

    @Override
    public CompetenceAvaliationEntity getById(Long id) {
        var query = competenceAvaliationRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Competence not found");

        return query.get();
    }

    @Override
    public List<CompetenceAvaliationEntity> getAll() {
        return (List<CompetenceAvaliationEntity>) competenceAvaliationRepository.findAll();
    }

    @Override
    public CompetenceAvaliationEntity update(Long id, CompetenceAvaliationEntityUpdatePayload payload) {
        var query = competenceAvaliationRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Competence not found");

        var entity = query.get();

        if (payload.getStatus() != null) entity.setStatus(CompetenceLevel.valueOf(payload.getStatus()));

        if (payload.getCompetenceEntityId() != null) {
            var q = competenceRepository.findById((payload.getCompetenceEntityId()));
            if (q.isEmpty()) throw new NotFoundException("Competence not found");

            entity.setCompetence(q.get());
        }

        if (payload.getAvaliationEntityId() != null) {
            var q = avaliationRepository.findById((payload.getAvaliationEntityId()));
            if (q.isEmpty()) throw new NotFoundException("Avaliation not found");
            entity.setAvaliationEntity(q.get());
        }

        return competenceAvaliationRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        var query = competenceAvaliationRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Competence not found");

        competenceAvaliationRepository.delete(query.get());
    }
}
