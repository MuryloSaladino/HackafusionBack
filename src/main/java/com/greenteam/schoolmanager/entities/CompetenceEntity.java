package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table @Getter
public class CompetenceEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Float weight;

    @ManyToOne @JoinColumn(nullable = false) @Setter
    private DisciplineEntity disciplineEntity;


    public void setName(String name){
        this.update();
        this.name = name;
    }

    public void setDescription(String description){
        this.update();
        this.description = description;
    }

    public void setWeight(Float weight){
        this.update();
        this.weight = weight;
    }


    public CompetenceEntity(){}
    public CompetenceEntity(String name, String description, Float weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
}
