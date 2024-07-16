package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.exceptions.UnauthorizedException;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.LoginService;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceDefault implements LoginService {

    @Autowired
    JwtTokenManager jwtTokenManager;

    @Autowired
    UserEntityService userEntityService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String login(String usernameOrEmail, String password) {

        var user = userEntityService.getByUsernameOrEmail(usernameOrEmail);

        if(!bCryptPasswordEncoder.matches(password, user.getPassword()))
            throw new UnauthorizedException("Wrong password");

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", UserRole.roleToInteger(user.getRole()));

        return jwtTokenManager.buildToken(claims, user.getUsername(), user.getId());
    }
}
