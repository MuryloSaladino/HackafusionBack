package com.greenteam.schoolmanager.dto.register;

import com.greenteam.schoolmanager.entities.PreRegisterEntity;

public class PreRegisterResponse {

    public String email;
    public String role;
    public Long gangId;

    public PreRegisterResponse(PreRegisterEntity preRegisterEntity) {
        this.email = preRegisterEntity.getEmail();
        this.role = preRegisterEntity.getRole().toString();
        this.gangId = preRegisterEntity.getId();
    }
}
