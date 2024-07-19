package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.question.QuestionEntityCreationPayload;
import com.greenteam.schoolmanager.dto.question.QuestionEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.QuestionEntity;

import java.util.List;

public interface QuestionEntityService {
    QuestionEntity create(QuestionEntityCreationPayload payload);
    QuestionEntity update(Long id, QuestionEntityUpdatePayload payload);
    void delete(Long id);
    List<QuestionEntity> getAll();
}
