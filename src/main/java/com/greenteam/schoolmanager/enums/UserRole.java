package com.greenteam.schoolmanager.enums;

public enum UserRole {
    ADMIN,
    INSTRUCTOR,
    STUDENT;

    public static Integer roleToInteger(final UserRole role) {
        return switch (role) {
            case ADMIN -> 0;
            case INSTRUCTOR -> 1;
            case STUDENT -> 2;
        };
    }

    public static UserRole integerToRole(Integer integer) {
        return switch (integer) {
            case 0 -> ADMIN;
            case 1 -> INSTRUCTOR;
            case 2 -> STUDENT;
            default -> null;
        };
    }
}
