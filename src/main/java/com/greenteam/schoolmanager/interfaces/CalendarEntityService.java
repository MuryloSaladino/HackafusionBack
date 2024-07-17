package com.greenteam.schoolmanager.interfaces;

import com.greenteam.schoolmanager.dto.calendar.CalendarEntityCreationPayload;
import com.greenteam.schoolmanager.dto.calendar.CalendarEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CalendarEventEntity;

import java.util.List;

public interface CalendarEntityService {
    CalendarEventEntity create(CalendarEntityCreationPayload payload);
    CalendarEventEntity getById(Long id);
    List<CalendarEventEntity> getByDate(Integer year, Integer month);
    List<CalendarEventEntity> getByGangAndDate(Long gangId, Integer year, Integer month);
    CalendarEventEntity update(Long id, CalendarEntityUpdatePayload payload);
    void delete(Long id);
}
