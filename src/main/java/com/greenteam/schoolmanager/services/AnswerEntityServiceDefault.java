package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.answer.AnswerEntityCreationPayload;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.AnswerEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.AnswerEntityService;
import com.greenteam.schoolmanager.repositories.AnswerRepository;
import com.greenteam.schoolmanager.repositories.QuestionRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerEntityServiceDefault implements AnswerEntityService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public AnswerEntity create(AnswerEntityCreationPayload payload) {

        AnswerEntity answerEntity = payload.toEntity();

        var questionQuery = questionRepository.findById(payload.getQuestionId());
        if (questionQuery.isEmpty()) throw new NotFoundException("Question not found");

        var userQuery = userRepository.findById(payload.getUserId());
        if (userQuery.isEmpty()) throw new NotFoundException("User not found");

        answerEntity.setQuestion(questionQuery.get());
        answerEntity.setUser(userQuery.get());

        return answerRepository.save(answerEntity);
    }

    @Override
    public AnswerEntity update(Long id, AnswerEntityUpdatePayload payload) {

        var query = answerRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException("Answer not found");

        var entity = query.get();

        if (payload.getDescription() != null) entity.setDescription(payload.getDescription());

        return answerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {

        var query = answerRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        answerRepository.delete(query.get());
    }

    @Override
    public AnswerEntity getById(Long id) {

        var query = answerRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<AnswerEntity> getAll() {
        return (List<AnswerEntity>) answerRepository.findAll();
    }

    @Override
    public List<AnswerEntity> getByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
