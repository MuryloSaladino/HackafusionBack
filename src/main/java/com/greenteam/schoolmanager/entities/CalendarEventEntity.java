package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Table @Entity @Getter
public class CalendarEventEntity extends BaseEntity {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer year;

    @Column
    private Integer month;

    @ManyToOne @JoinColumn(nullable = false)
    private StudentGangEntity studentGangEntity;

    @ManyToOne @JoinColumn()
    private UserEntity userEntity;


    public CalendarEventEntity(){ };

    public CalendarEventEntity(String title, String description, Integer year, Integer month) {
        super();
        this.title= title;
        this.description = description;
        this.year = year;
        this.month = month;
    }

    public void setTitle(String title) {
        this.update();
        this.title = title;
    }

    public void setDescription(String description) {
        this.update();
        this.description = description;
    }

    public void setStudentGangEntity(StudentGangEntity studentGangEntity) {
        this.update();
        this.studentGangEntity = studentGangEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.update();
        this.userEntity = userEntity;
    }

    public void setYear(Integer year) {
        this.update();
        this.year = year;
    }

    public void setMonth(Integer month) {
        this.update();
        this.month = month;
    }
}
