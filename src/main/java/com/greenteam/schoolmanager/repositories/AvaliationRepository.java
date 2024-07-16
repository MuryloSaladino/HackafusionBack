package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.AvaliationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliationRepository extends CrudRepository <AvaliationEntity, Long> {}
