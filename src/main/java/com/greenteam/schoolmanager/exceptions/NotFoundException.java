package com.greenteam.schoolmanager.exceptions;

public class NotFoundException extends ResponseException {
    public NotFoundException() {
        super("The requested entity was not found", 404);
    }
    public NotFoundException(String message) {
        super(message, 404);
    }
}

