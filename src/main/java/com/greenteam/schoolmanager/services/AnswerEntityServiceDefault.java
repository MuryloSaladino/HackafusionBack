package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.answer.AnswerEntityCreationPayload;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.AnswerEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.AnswerEntityService;
import com.greenteam.schoolmanager.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerEntityServiceDefault implements AnswerEntityService {

    @Autowired
    AnswerRepository answerRepository;


    @Override
    public AnswerEntity create(AnswerEntityCreationPayload payload) {
        return null;
    }

    @Override
    public AnswerEntity update(Long id, AnswerEntityUpdatePayload payload) {
        return null;
    }

    @Override
    public void delete(Long id) {

        var query = answerRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        answerRepository.delete(query.get());
    }

    @Override
    public List<AnswerEntity> getById(Long id) {
        return null;
    }

    @Override
    public List<AnswerEntity> getAll() {
        return List.of();
    }
}
