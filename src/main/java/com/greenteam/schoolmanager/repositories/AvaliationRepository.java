package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.AvaliationEntity;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliationRepository extends CrudRepository <AvaliationEntity, Long> {
    List<AvaliationEntity> findByUser(UserEntity user);
    Optional<AvaliationEntity> findByUserAndDisciplineEntity(UserEntity user, DisciplineEntity discipline);
}
