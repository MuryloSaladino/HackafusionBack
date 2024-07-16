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

    @Column @Enumerated(EnumType.STRING)
    private CompetenceLevel status;

    public void setStatus(CompetenceLevel status) {
        this.update();
        this.status = status;
    }
}
