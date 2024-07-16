package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class StudentGangDisciplineEntity extends BaseEntity {

    @ManyToOne() @JoinColumn(nullable = false)
    private StudentGangEntity gang;

    @ManyToOne() @JoinColumn(nullable = false)
    private DisciplineEntity discipline;
}
