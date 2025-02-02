package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne() @JoinColumn()
    private StudentGangEntity studentGang;


    public UserEntity() {}

    public UserEntity(String username, String password, String fullname, String email, UserRole role) {
        super();
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.role = role;
    }


    public void setUsername(String username) {
        this.update();
        this.username = username;
    }

    public void setPassword(String password) {
        this.update();
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.update();
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.update();
        this.email = email;
    }

    public void setRole(UserRole role) {
        this.update();
        this.role = role;
    }

    public void setStudentGang(StudentGangEntity studentGang) {
        this.update();
        this.studentGang = studentGang;
    }
}
