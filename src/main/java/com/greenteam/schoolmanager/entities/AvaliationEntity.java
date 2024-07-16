package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.CompetenceLevel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity @Table @Getter
public class AvaliationEntity extends BaseEntity {

    @ManyToOne @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne @JoinColumn(nullable = false)
    private DisciplineEntity disciplineEntity;


    public void setUser(UserEntity user) {
        this.update();
        this.user = user;
    }

    public void setDiscipline (DisciplineEntity discipline) {
        this.update();
        this.disciplineEntity = discipline;
    }
}
