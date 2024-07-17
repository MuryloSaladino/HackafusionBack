package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.user.PreRegisterPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.entities.UserEntity;

public interface PreRegisterService {
    void createPreRegister(PreRegisterPayload payload);
    String getByEmail(String email);
    UserEntity createFromPreRegister(UserEntityCreationPayload payload);
}
