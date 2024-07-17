package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table @Getter @Setter
public class PreRegisterEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne() @JoinColumn()
    private StudentGangEntity studentGang;


    public PreRegisterEntity() {}

    public PreRegisterEntity(String email, UserRole role) {
        this.email = email;
        this.role = role;
    }
}
