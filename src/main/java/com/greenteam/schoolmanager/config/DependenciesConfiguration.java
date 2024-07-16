package com.greenteam.schoolmanager.config;

import com.greenteam.schoolmanager.interfaces.*;
import com.greenteam.schoolmanager.services.*;
import com.greenteam.schoolmanager.sessions.UserSession;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DependenciesConfiguration {

    @Bean @Scope() @Primary
    public JwtTokenManager jwtTokenManager() {
        return new JwtTokenManagerDefault();
    }

    @Bean @Scope() @Primary
    public LoginService loginService() { return new LoginServiceDefault(); }

    @Bean @Scope() @Primary
    public StudentGangService studentGangService() { return new StudentGangServiceDefault(); }

    @Bean @Scope() @Primary
    public UserEntityService userEntityService() {
        return new UserEntityServiceDefault();
    }

    @Bean @Scope() @Primary
    public DisciplineEntityService disciplineEntityService() { return new DisciplineEntityServiceDefault(); }

    @Bean @Scope() @Primary
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS) @Primary
    public UserSession userSession() { return new UserSession(); }
}
