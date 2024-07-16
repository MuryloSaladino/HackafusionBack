package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class StudentGangDisciplineEntity extends BaseEntity {

    @ManyToOne() @JoinColumn(nullable = false)
    private StudentGangEntity gang;

    @ManyToOne() @JoinColumn(nullable = false)
    private DisciplineEntity discipline;


    public void setGang(StudentGangEntity gang) {
        this.update();
        this.gang = gang;
    }

    public void setDiscipline(DisciplineEntity discipline) {
        this.update();
        this.discipline = discipline;
    }
}
