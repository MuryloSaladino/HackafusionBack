package com.greenteam.schoolmanager.interfaces;



import com.greenteam.schoolmanager.dto.competence.CompetenceEntityCreationPayload;
import com.greenteam.schoolmanager.dto.competence.CompetenceEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CompetenceEntity;

import java.util.List;

public interface CompetenceEntityService {
    CompetenceEntity create(CompetenceEntityCreationPayload payload);
    CompetenceEntity getById(Long id);
    List<CompetenceEntity> getAll();
    CompetenceEntity update(Long id, CompetenceEntityUpdatePayload payload);
    void delete(Long id);
}
