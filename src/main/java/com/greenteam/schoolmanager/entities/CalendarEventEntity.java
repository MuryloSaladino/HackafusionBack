package com.greenteam.schoolmanager.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.Date;

@Table @Entity @Getter
public class CalendarEventEntity extends BaseEntity {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne @JoinColumn(nullable = false)
    private StudentGangEntity studentGangEntity;

    @ManyToOne @JoinColumn()
    private UserEntity userEntity;


    public CalendarEventEntity(){ };

    public CalendarEventEntity(String title, String description, Date date) {
        super();
        this.title= title;
        this.description = description;
        this.date = date;
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

    public void setDate(Date date) {
        this.update();
        this.date = date;
    }
}
