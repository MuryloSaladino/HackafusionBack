package com.greenteam.schoolmanager.dto.user;

import com.greenteam.schoolmanager.dto.gang.StudentGangEntityResponse;
import com.greenteam.schoolmanager.entities.UserEntity;

public class UserEntityResponse {

    public Long id;
    public String username;
    public String fullname;
    public String email;
    public String role;
    public StudentGangEntityResponse studentGang;


    public UserEntityResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.fullname = userEntity.getFullname();
        this.email = userEntity.getEmail();
        this.role = userEntity.getRole().toString();

        if(userEntity.getStudentGang() != null) {
            this.studentGang = new StudentGangEntityResponse(userEntity.getStudentGang());
        }
    }
}
