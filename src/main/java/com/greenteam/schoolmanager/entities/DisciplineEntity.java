package com.greenteam.schoolmanager.entities;

import com.greenteam.schoolmanager.enums.DisciplineType;
import jakarta.persistence.*;
import lombok.Getter;

@Table @Entity @Getter
public class DisciplineEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private String description;

    @Column(nullable = false)
    private Float workload;

    @Column @Enumerated(EnumType.STRING)
    private DisciplineType type;


    public DisciplineEntity() {}

    public DisciplineEntity(String name, String description, Float workload, DisciplineType type) {
        super();
        this.name = name;
        this.description = description;
        this.workload = workload;
        this.type = type;
    }

    public void setName(String name) {
        this.update();
        this.name = name;
    }

    public void setType(DisciplineType type) {
        this.update();
        this.type = type;
    }

    public void setDescription(String description) {
        this.update();
        this.description = description;
    }

    public void setWorkload(Float workload) {
        this.update();
        this.workload = workload;
    }
}
