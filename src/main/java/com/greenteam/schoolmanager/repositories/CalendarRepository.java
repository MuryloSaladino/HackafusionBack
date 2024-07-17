package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CalendarRepository extends CrudRepository<CalendarEventEntity, Long> {
    List<CalendarEventEntity> findByYearAndMonth(Integer year, Integer month);
    List<CalendarEventEntity> findByStudentGangEntityIdAndYearAndMonth(Long gang, Integer year, Integer month);
}
