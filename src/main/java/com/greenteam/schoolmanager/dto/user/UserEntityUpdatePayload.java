package com.greenteam.schoolmanager.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class UserEntityUpdatePayload {

    @Size(min = 8, max = 50)
    private String username;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    private String password;

    @Size(min = 8, max = 100)
    private String fullname;

    @Email
    private String email;
}
