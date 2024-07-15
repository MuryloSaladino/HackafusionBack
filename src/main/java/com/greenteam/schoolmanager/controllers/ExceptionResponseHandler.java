package com.greenteam.schoolmanager.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.greenteam.schoolmanager.exceptions.ResponseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionResponseHandler {

    public record Message(String message) {}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<Message> responseError(ResponseException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(ex.getStatusCode())
                .body(new Message(ex.getMessage()));
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<Message> handleDataIntegrityViolation(Exception ex, HttpServletRequest request) {
        return ResponseEntity
                .status(400)
                .body(new Message(
                        "Something went wrong with your request." +
                                "Maybe you tried creating something that already exists in out database" +
                                "or your request does not fit our requirements."
                ));
    }
}
