package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {}
