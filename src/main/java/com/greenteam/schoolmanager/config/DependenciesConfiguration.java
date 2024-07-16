package com.greenteam.schoolmanager.config;

import com.greenteam.schoolmanager.interfaces.DisciplineEntityService;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.services.DisciplineEntityServiceDefault;
import com.greenteam.schoolmanager.services.JwtTokenManagerDefault;
import com.greenteam.schoolmanager.services.UserEntityServiceDefault;
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
