package com.greenteam.schoolmanager.controllers;

import com.greenteam.schoolmanager.dto.calendar.CalendarEntityCreationPayload;
import com.greenteam.schoolmanager.dto.calendar.CalendarEntityResponse;
import com.greenteam.schoolmanager.dto.calendar.CalendarEntityUpdatePayload;
import com.greenteam.schoolmanager.interfaces.CalendarEntityService;
import com.greenteam.schoolmanager.sessions.UserSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    @Autowired
    private UserSession userSession;

    @Autowired
    private CalendarEntityService calendarEntityService;

    @PostMapping
    protected ResponseEntity<CalendarEntityResponse> createCalendar(
            @Valid @RequestBody CalendarEntityCreationPayload body
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(201)
                .body(new CalendarEntityResponse( calendarEntityService.create(body) ));
    }

    @PatchMapping("/{id}")
    protected ResponseEntity<CalendarEntityResponse> updateCalendar(
            @Valid @RequestBody CalendarEntityUpdatePayload body,
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new CalendarEntityResponse( calendarEntityService.update(id, body) ));
    }

    @DeleteMapping("/{id}")
    protected ResponseEntity<?> deleteCalendar(
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        calendarEntityService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    protected ResponseEntity<CalendarEntityResponse> getCalendarById(
            @PathVariable Long id
    ) {
        userSession.verifyInstructorOrAdmin();

        return ResponseEntity
                .status(200)
                .body(new CalendarEntityResponse( calendarEntityService.getById(id) ));
    }

    @GetMapping("/year/{year}/month/{month}")
    protected ResponseEntity<List<CalendarEntityResponse>> getCalendarByYearMonth(
            @PathVariable @Positive Integer year,
            @PathVariable @Min(1) @Max(12) Integer month
    ) {
        userSession.verifyToken();

        return ResponseEntity.ok(calendarEntityService
                .getByDate(year, month)
                .stream()
                .map(CalendarEntityResponse::new)
                .toList()
        );
    }
}
