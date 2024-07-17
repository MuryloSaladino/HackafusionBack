package com.greenteam.schoolmanager.dto.register;

import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class PreRegisterPayload {

    @NotNull @Email
    private String email;

    @NotNull @Min(0) @Max(2)
    private Integer role;

    @Positive
    private Long studentGangId;

    public PreRegisterEntity toEntity() {
        return new PreRegisterEntity(email, UserRole.integerToRole(role));
    }
}
