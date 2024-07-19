package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {
}
