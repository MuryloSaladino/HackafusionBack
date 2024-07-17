package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.AvaliationEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliationRepository extends CrudRepository <AvaliationEntity, Long> {
    List<AvaliationEntity> findByUser(UserEntity user);
}
