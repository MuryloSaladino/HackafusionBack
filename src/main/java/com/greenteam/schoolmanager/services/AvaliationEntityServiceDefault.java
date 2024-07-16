package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.avaliation.AvaliationEntityCreationPayload;
import com.greenteam.schoolmanager.entities.AvaliationEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.AvaliationEntityService;
import com.greenteam.schoolmanager.repositories.AvaliationRepository;
import com.greenteam.schoolmanager.repositories.DisciplineRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliationEntityServiceDefault implements AvaliationEntityService {

    @Autowired
    AvaliationRepository avaliationRepository;

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AvaliationEntity create(AvaliationEntityCreationPayload payload) {
        AvaliationEntity newAvaliation = payload.toEntity();

        var queryUser = userRepository.findById(payload.getUserId());
        if(queryUser.isEmpty()) throw new NotFoundException();

        newAvaliation.setUser(queryUser.get());

        var queryDiscipline = disciplineRepository.findById(payload.getDisciplineId());
        if(queryDiscipline.isEmpty()) throw new NotFoundException();

        newAvaliation.setDiscipline(queryDiscipline.get());

        return avaliationRepository.save(newAvaliation);
    }

    @Override
    public AvaliationEntity getById(Long id) {
        var query = avaliationRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<AvaliationEntity> getAll() { return (List<AvaliationEntity>) avaliationRepository.findAll(); }

    @Override
    public void delete(Long id) {

        var query = avaliationRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        avaliationRepository.delete(query.get());
    }
}
