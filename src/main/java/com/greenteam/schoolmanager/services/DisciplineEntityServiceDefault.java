package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityCreationPayload;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.enums.DisciplineType;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.DisciplineEntityService;
import com.greenteam.schoolmanager.repositories.DisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangDisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineEntityServiceDefault implements DisciplineEntityService {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    StudentGangRepository gangRepository;

    @Autowired
    StudentGangDisciplineRepository studentGangDisciplineRepository;

    @Override
    public DisciplineEntity create(DisciplineEntityCreationPayload payload) {
        return disciplineRepository.save(payload.toEntity());
    }

    @Override
    public DisciplineEntity getById(Long id) {

        var query =  disciplineRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<DisciplineEntity> getAll() {
        return (List<DisciplineEntity>) disciplineRepository.findAll();
    }

    @Override
    public List<DisciplineEntity> getByGang(Long gangId) {

        var query = gangRepository.findById(gangId);
        if(query.isEmpty()) throw new NotFoundException();

        return studentGangDisciplineRepository
                .findByGang(query.get())
                .stream()
                .map(StudentGangDisciplineEntity::getDiscipline)
                .toList();
    }

    @Override
    public DisciplineEntity update(Long id, DisciplineEntityUpdatePayload payload) {
        var query =  disciplineRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        var discipline = query.get();
        if (payload.getName() != null) discipline.setName(payload.getName());
        if (payload.getDescription() != null) discipline.setDescription(payload.getDescription());
        if (payload.getWorkload() != null) discipline.setWorkload(payload.getWorkload());
        if (payload.getType() != null) discipline.setType(DisciplineType.valueOf(payload.getType()));

        return disciplineRepository.save(discipline);
    }

    @Override
    public void delete(Long id) {
        var query =  disciplineRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        disciplineRepository.delete(query.get());
    }
}
