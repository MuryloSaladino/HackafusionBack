package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;

import java.util.List;

public interface CompetenceAvaliationEntityService {
    CompetenceAvaliationEntity create(CompetenceAvaliationEntityCreationPayload payload);
    CompetenceAvaliationEntity getById(Long id);
    CompetenceAvaliationEntity update(Long id, CompetenceAvaliationEntityUpdatePayload payload);
    void delete(Long id);
}
