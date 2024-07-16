package com.greenteam.schoolmanager.dto.user;

import com.greenteam.schoolmanager.dto.gang.StudentGangEntityResponse;
import com.greenteam.schoolmanager.entities.UserEntity;

public class UserEntityResponse {

    public String username;
    public String fullname;
    public String email;
    public String role;
    public StudentGangEntityResponse studentGang;


    public UserEntityResponse(UserEntity userEntity) {
        this.username = userEntity.getUsername();
        this.fullname = userEntity.getFullname();
        this.email = userEntity.getEmail();
        this.role = userEntity.getRole().toString();
        this.studentGang = new StudentGangEntityResponse(userEntity.getStudentGang());
    }
}
