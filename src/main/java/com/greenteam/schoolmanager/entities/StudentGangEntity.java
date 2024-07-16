package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.DisciplineType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity @Table @Getter
public class StudentGangEntity extends BaseEntity {

    @Column() @Enumerated(EnumType.STRING)
    private DisciplineType mainDisciplineType;

    @Column()
    private String name;


    public StudentGangEntity() {}

    public StudentGangEntity(DisciplineType mainDisciplineType, String name) {
        super();
        this.mainDisciplineType = mainDisciplineType;
        this.name = name;
    }


    public void setMainDisciplineType(DisciplineType mainDisciplineType) {
        this.update();
        this.mainDisciplineType = mainDisciplineType;
    }

    public void setName(String name) {
        this.update();
        this.name = name;
    }
}
