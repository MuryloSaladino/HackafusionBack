package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.calendar.CalendarEntityCreationPayload;
import com.greenteam.schoolmanager.dto.calendar.CalendarEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.CalendarEventEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.CalendarEntityService;
import com.greenteam.schoolmanager.repositories.CalendarRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEntityServiceDefault implements CalendarEntityService {

    @Autowired
    CalendarRepository calendarRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentGangRepository studentGangRepository;

    @Override
    public CalendarEventEntity create(CalendarEntityCreationPayload payload) {
        CalendarEventEntity newCalendar = payload.toEntity();

        var queryUser = userRepository.findById(payload.getUserEntityId());
        if(queryUser.isEmpty()) throw new NotFoundException();

        newCalendar.setUserEntity(queryUser.get());

        var queryStudentGang = studentGangRepository.findById(payload.getStudentGangId());
        if(queryStudentGang.isEmpty()) throw new NotFoundException();

        newCalendar.setStudentGangEntity(queryStudentGang.get());

        return calendarRepository.save(newCalendar);
    }

    @Override
    public CalendarEventEntity getById(Long id) {

        var query = calendarRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<CalendarEventEntity> getByDate(Integer year, Integer month) {
        return calendarRepository.findByYearAndMonth(year, month);
    }

    @Override
    public List<CalendarEventEntity> getByGangAndDate(Long gangId, Integer year, Integer month) {
        return calendarRepository.findByStudentGangEntityIdAndYearAndMonth(gangId, year, month);
    }

    @Override
    public CalendarEventEntity update(Long id, CalendarEntityUpdatePayload payload) {
        var query = calendarRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        var calendar = query.get();
        if(payload.getTitle() != null) calendar.setTitle(payload.getTitle());
        if(payload.getDescription() != null) calendar.setDescription(payload.getDescription());
        if(payload.getYear() != null) calendar.setYear(payload.getYear());
        if(payload.getMonth() != null) calendar.setMonth(payload.getMonth());

        return calendarRepository.save(calendar);
    }

    @Override
    public void delete(Long id) {
        var query = calendarRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        calendarRepository.delete(query.get());
    }
}
