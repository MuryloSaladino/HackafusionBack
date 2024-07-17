package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.UserEntity;

import java.util.List;

public interface UserEntityService {
    UserEntity create(UserEntityCreationPayload payload);
    UserEntity getById(Long id);
    UserEntity getByUsernameOrEmail(String usernameOrEmail);
    List<UserEntity> getAll();
    List<UserEntity> getStudentsByGang(Long gangId);
    List<UserEntity> getAllStudents();
    UserEntity update(Long id, UserEntityUpdatePayload payload);
    void delete(Long id);
}
