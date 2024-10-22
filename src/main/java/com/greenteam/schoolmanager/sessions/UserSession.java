package com.greenteam.schoolmanager.sessions;

import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.exceptions.ForbiddenException;
import com.greenteam.schoolmanager.exceptions.UnauthorizedException;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSession {

    private Long id;
    private UserRole userRole;


    public void verifyAdmin() {
        verifyToken();
        if(!userRole.equals(UserRole.ADMIN)) throw new ForbiddenException();
    }

    public void verifyInstructorOrAdmin() {
        verifyToken();
        if (userRole.equals(UserRole.STUDENT)) throw new ForbiddenException();
    }

    public void verifyToken() {
        if(id == null) throw new UnauthorizedException();
    }

    public void verifyOwnUserOrAdmin(Long userId) {
        if(id == null) throw new UnauthorizedException();
        if(id.equals(userId)) return;
        if(!userRole.equals(UserRole.ADMIN)) throw new ForbiddenException();
    }

    public void verifyAdminOrInstructorOrOwnUser(Long id) {
        verifyToken();

        if(this.id.equals(id)) return;

        if(userRole.equals(UserRole.STUDENT)) throw new ForbiddenException();
    }

    public void verifyOwnUser(Long userId) {
        verifyToken();
        if(!id.equals(userId)) throw new ForbiddenException();
    }
}
