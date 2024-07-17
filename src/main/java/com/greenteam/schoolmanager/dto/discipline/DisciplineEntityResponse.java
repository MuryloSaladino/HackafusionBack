package com.greenteam.schoolmanager.dto.discipline;

import com.greenteam.schoolmanager.entities.DisciplineEntity;

public class DisciplineEntityResponse {

    public Long id;
    public String name;
    public String description;
    public Float workload;
    public String type;

    public DisciplineEntityResponse(DisciplineEntity discipline) {
        this.id = discipline.getId();
        this.name = discipline.getName();
        this.description = discipline.getDescription();
        this.workload = discipline.getWorkload();
        this.type = discipline.getType().toString();
    }
}
