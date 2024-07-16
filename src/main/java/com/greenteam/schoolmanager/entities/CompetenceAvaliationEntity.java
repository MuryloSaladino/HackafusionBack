package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.CompetenceLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table @Getter
public class CompetenceAvaliationEntity extends BaseEntity {

    @Column() @Enumerated(EnumType.STRING)
    private CompetenceLevel competenceLevel;

    @ManyToOne @JoinColumn(nullable = false)
    @Setter
    private CompetenceEntity competence;

    @ManyToOne @JoinColumn(nullable = false)
    @Setter
    private AvaliationEntity avaliationEntity;


    public void setCompetenceLevel(CompetenceLevel competenceLevel) {
        this.update();
        this.competenceLevel = competenceLevel;
    }

    public CompetenceAvaliationEntity() {}
    public CompetenceAvaliationEntity(String competenceLevel) {
        this.competenceLevel = CompetenceLevel.valueOf(competenceLevel);
    }
}
