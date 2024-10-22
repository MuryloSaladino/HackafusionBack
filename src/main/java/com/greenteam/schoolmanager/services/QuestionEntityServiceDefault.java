package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.question.QuestionEntityCreationPayload;
import com.greenteam.schoolmanager.dto.question.QuestionEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.QuestionEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.QuestionEntityService;
import com.greenteam.schoolmanager.repositories.QuestionRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionEntityServiceDefault implements QuestionEntityService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public QuestionEntity create(QuestionEntityCreationPayload payload) {

        QuestionEntity questionEntity = payload.toEntity();

        var userQuery = userRepository.findById(payload.getUserId());
        if (userQuery.isEmpty()) throw new NotFoundException("User not found");

        questionEntity.setUser(userQuery.get());

        return questionRepository.save(questionEntity);
    }

    @Override
    public QuestionEntity update(Long id, QuestionEntityUpdatePayload payload) {
        var query = questionRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        var question = query.get();
        if (payload.getTitle() != null) question.setTitle(payload.getTitle());
        if (payload.getDescription() != null) question.setDescription(payload.getDescription());

        return questionRepository.save(question);
    }

    @Override
    public void delete(Long id) {
        var query = questionRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        questionRepository.delete(query.get());
    }

    @Override
    public List<QuestionEntity> getAll() {
        return (List<QuestionEntity>)questionRepository.findAll();
    }
}
