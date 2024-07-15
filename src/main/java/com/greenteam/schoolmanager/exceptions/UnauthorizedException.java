package com.greenteam.schoolmanager.exceptions;

public class UnauthorizedException extends ResponseException {
    public UnauthorizedException() {
        super("You do not own authorization to do the requested action", 401);
    }
    public UnauthorizedException(String message) { super(message, 401); }
}

