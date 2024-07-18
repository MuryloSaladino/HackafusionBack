package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    List<UserEntity> findByStudentGangId(Long studentGangId);
    List<UserEntity> findByRole(UserRole role);
}
