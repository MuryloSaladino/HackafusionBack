package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {}