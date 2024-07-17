package com.greenteam.schoolmanager.dto.calendar;


import com.greenteam.schoolmanager.dto.gang.StudentGangEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.CalendarEventEntity;

import java.util.Date;

public class CalendarEntityResponse {

    public Long id;
    public String title;
    public String description;
    public Date date;
    public StudentGangEntityResponse studentGang;
    public UserEntityResponse user;


    public CalendarEntityResponse(CalendarEventEntity calendarEventEntity) {
        this.id = calendarEventEntity.getId();
        this.title = calendarEventEntity.getTitle();
        this.description = calendarEventEntity.getDescription();
        this.date = calendarEventEntity.getDate();
        this.studentGang = new StudentGangEntityResponse( calendarEventEntity.getStudentGangEntity() );
        this.user = new UserEntityResponse( calendarEventEntity.getUserEntity() );
    }
}
