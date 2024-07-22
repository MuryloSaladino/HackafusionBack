package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.answer.AnswerEntityCreationPayload;
import com.greenteam.schoolmanager.dto.answer.AnswerEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.AnswerEntity;

import java.util.List;

public interface AnswerEntityService {
    AnswerEntity create(AnswerEntityCreationPayload payload);
    AnswerEntity update(Long id, AnswerEntityUpdatePayload payload);
    void delete(Long id);
    AnswerEntity getById(Long id);
    List<AnswerEntity> getAll();
    List<AnswerEntity> getByQuestionId(Long questionId);
}
