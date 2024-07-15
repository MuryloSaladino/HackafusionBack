package com.greenteam.schoolmanager.exceptions;

public class BadRequestException extends ResponseException {
    public BadRequestException() {
        super("Request was not properly built", 400);
    }
    public BadRequestException(String message) {
        super(message, 400);
    }
}
