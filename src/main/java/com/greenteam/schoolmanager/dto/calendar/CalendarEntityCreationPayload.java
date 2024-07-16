package com.greenteam.schoolmanager.dto.calendar;

import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter @Data
public class CalendarEntityCreationPayload {

    @NotNull
    @Size(min = 4, max = 50)
    private String title;

    @NotNull
    @Size(min = 8, max = 100)
    private String description;

    @NotNull
    private Date date;

    @NotNull
    private Long studentGangId;

    @NotNull
    private Long userEntityId;

    public CalendarEventEntity toEntity() { return new CalendarEventEntity(title, description, date); }
}
