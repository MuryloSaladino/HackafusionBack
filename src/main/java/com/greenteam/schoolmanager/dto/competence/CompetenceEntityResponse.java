package com.greenteam.schoolmanager.dto.competence;

import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityResponse;
import com.greenteam.schoolmanager.entities.CompetenceEntity;

public class CompetenceEntityResponse {

    public Long id;
    public String name;
    public String description;
    public Float weight;

    public CompetenceEntityResponse(CompetenceEntity competenceEntity) {
        this.id = competenceEntity.getId();
        this.name = competenceEntity.getName();
        this.description = competenceEntity.getDescription();
        this.weight = competenceEntity.getWeight();
    }
}
