package com.greenteam.schoolmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity @Table @Getter
public class AvaliationEntity extends BaseEntity {

    @ManyToOne @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne @JoinColumn(nullable = false)
    private DisciplineEntity disciplineEntity;
}
