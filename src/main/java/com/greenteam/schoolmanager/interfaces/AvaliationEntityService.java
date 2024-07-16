package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.avaliation.AvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.dto.avaliation.AvaliationEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.AvaliationEntity;

import java.util.List;

public interface AvaliationEntityService {
    AvaliationEntity create(AvaliationEntityCreationPayload payload);
    AvaliationEntity getById(Long id);
    List<AvaliationEntity> getAll();
    void delete(Long id);
}
