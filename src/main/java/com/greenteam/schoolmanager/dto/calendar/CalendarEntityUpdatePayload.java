package com.greenteam.schoolmanager.dto.calendar;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class CalendarEntityUpdatePayload {

    @Size(min = 4, max = 50)
    private String title;

    @Size(min = 8, max = 100)
    private String description;

    @Positive
    private Integer year;

    @Positive
    private Integer month;
}
