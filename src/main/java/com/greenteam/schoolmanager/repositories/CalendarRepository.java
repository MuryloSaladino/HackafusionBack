package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface CalendarRepository extends CrudRepository<CalendarEventEntity, Long> {
    @Query("select c from CalendarEventEntity c where year(c.date) = ?1 and month(c.date) = ?2")
    List<CalendarEventEntity> findByDateMonthAndDateYear(Integer year, Integer month);

    @Query("select c from CalendarEventEntity c inner join StudentGangEntity s on c.studentGangEntity.id = s.id where year(c.date) = ?1 and month(c.date) = ?2 and s.id = ?3")
    List<CalendarEventEntity> findByDateMonthAndDateYearAndStudentGangEntity(
            Integer year, Integer month, StudentGangEntity studentGangEntity
    );
}
