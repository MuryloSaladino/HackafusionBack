package com.greenteam.schoolmanager.entities;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Getter;

@MappedSuperclass @Getter
public class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column() @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column() @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp updatedAt;

    @Column() @Temporal(TemporalType.TIMESTAMP)
    protected Timestamp deletedAt;


    protected BaseEntity() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public void update() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
