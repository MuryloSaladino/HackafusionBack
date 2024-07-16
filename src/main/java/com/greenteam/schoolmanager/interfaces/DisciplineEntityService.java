package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityCreationPayload;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.DisciplineEntity;

import java.util.List;

public interface DisciplineEntityService {
    DisciplineEntity create(DisciplineEntityCreationPayload payload);
    DisciplineEntity getById(Long id);
    List<DisciplineEntity> getAll();
    DisciplineEntity update(Long id, DisciplineEntityUpdatePayload payload);
    void delete(Long id);
}
