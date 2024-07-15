package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.CompetenceLevel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity @Table @Getter
public class CompetenceAvaliationEntity extends BaseEntity {

    @Column() @Enumerated(EnumType.STRING)
    private CompetenceLevel competenceLevel;

    @ManyToOne @JoinColumn(nullable = false)
    private CompetenceEntity competence;

    @ManyToOne @JoinColumn(nullable = false)
    private AvaliationEntity avaliationEntity;


    public void setCompetenceLevel(CompetenceLevel competenceLevel) {
        this.update();
        this.competenceLevel = competenceLevel;
    }
}
