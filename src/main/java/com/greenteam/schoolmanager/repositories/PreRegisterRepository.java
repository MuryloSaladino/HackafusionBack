package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PreRegisterRepository extends CrudRepository<PreRegisterEntity, Long> {
    Optional<PreRegisterEntity> findByEmail(String email);
}
