package com.greenteam.schoolmanager.dto.user;

import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserEntityCreationPayload {

    @NotNull
    @Size(min = 8, max = 50)
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @NotNull
    @Size(min = 8, max = 100)
    private String fullname;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Min(0) @Max(2)
    private Integer role;

    @Positive
    private Long studentGangId;


    public UserEntity toEntity() {
        return new UserEntity(username, password, fullname, email, UserRole.integerToRole(role));
    }
}
