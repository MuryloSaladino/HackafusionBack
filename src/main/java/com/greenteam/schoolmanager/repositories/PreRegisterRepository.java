package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PreRegisterRepository extends CrudRepository<PreRegisterEntity, Long> {
    Optional<PreRegisterEntity> findByEmail(String email);
}
