package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.calendar.CalendarEntityCreationPayload;
import com.greenteam.schoolmanager.dto.calendar.CalendarEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CalendarEventEntity;

import java.util.List;

public interface CalendarEntityService {
    CalendarEventEntity create(CalendarEntityCreationPayload payload);
    CalendarEventEntity getById(Long id);
    List<CalendarEventEntity> getAll();
    CalendarEventEntity update(Long id, CalendarEntityUpdatePayload payload);
    void delete(Long id);
}
