package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.register.PreRegisterPayload;
import com.greenteam.schoolmanager.dto.register.PreRegisterResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import com.greenteam.schoolmanager.entities.UserEntity;

public interface PreRegisterService {
    void createPreRegister(PreRegisterPayload payload);
    PreRegisterEntity getByEmail(String email);
    UserEntity createFromPreRegister(UserEntityCreationPayload payload);
}
