package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.CompetenceLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table @Getter
public class CompetenceAvaliationEntity extends BaseEntity {

    @Column() @Enumerated(EnumType.STRING)
    private CompetenceLevel status;

    @ManyToOne @JoinColumn(nullable = false)
    @Setter
    private CompetenceEntity competence;

    @ManyToOne @JoinColumn(nullable = false)
    @Setter
    private AvaliationEntity avaliationEntity;


    public void setStatus(CompetenceLevel competenceLevel) {
        this.update();
        this.status = competenceLevel;
    }

    public CompetenceAvaliationEntity() {}
    public CompetenceAvaliationEntity(String status) {
        this.update();
        this.status = CompetenceLevel.valueOf(status);
    }
}
