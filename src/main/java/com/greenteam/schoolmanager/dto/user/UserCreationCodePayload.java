package com.greenteam.schoolmanager.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserCreationCodePayload {

    @NotNull @Email
    private String email;

    @NotNull @Min(0) @Max(2)
    private Integer role;

    @Positive
    private Long studentGangId;
}
