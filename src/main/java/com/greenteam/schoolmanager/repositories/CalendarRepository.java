package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository extends CrudRepository<CalendarEventEntity, Long> {
}
