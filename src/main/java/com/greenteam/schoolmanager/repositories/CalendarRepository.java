package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CalendarRepository extends CrudRepository<CalendarEventEntity, Long> {
    List<CalendarEventEntity> findByDateMonthAndDateYear(Integer year, Integer month);
    List<CalendarEventEntity> findByDateMonthAndDateYearAndStudentGangEntity(
            Integer year, Integer month, StudentGangEntity studentGangEntity
    );
}
