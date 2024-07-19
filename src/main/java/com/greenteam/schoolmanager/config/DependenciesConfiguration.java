package com.greenteam.schoolmanager.config;

import com.greenteam.schoolmanager.interfaces.*;
import com.greenteam.schoolmanager.services.*;
import com.greenteam.schoolmanager.sessions.UserSession;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class DependenciesConfiguration {

    // # UTILITY BEANS
    @Bean @Scope() @Primary
    public JwtTokenManager jwtTokenManager() {
        return new JwtTokenManagerDefault();
    }
    @Bean @Scope() @Primary
    public BCryptPasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
    @Bean @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS) @Primary
    public UserSession userSession() { return new UserSession(); }


    // # DATABASE SERVICE BEANS
    @Bean @Scope() @Primary
    public CompetenceAvaliationEntityService competenceAvaliationEntityService() { return new CompetenceAvaliationServiceDefault(); }
    @Bean @Scope() @Primary
    public LoginService loginService() {
        return new LoginServiceDefault();
    }
    @Bean @Scope() @Primary
    public UserEntityService userEntityService() {
        return new UserEntityServiceDefault();
    }
    @Bean @Scope() @Primary
    public PreRegisterService preRegisterService() { return new PreRegisterServiceDefault(); }
    @Bean @Scope() @Primary
    public StudentGangDisciplineEntityService studentGangDisciplineService() {
        return new StudentGangDisciplineEntityServiceDefault();
    }
    @Bean @Scope() @Primary
    public StudentGangEntityService studentGangService() {
        return new StudentGangEntityServiceDefault();
    }
    @Bean @Scope() @Primary
    public CalendarEntityService calendarEntityService() {
        return new CalendarEntityServiceDefault();
    }
    @Bean @Scope() @Primary
    public DisciplineEntityService disciplineEntityService() {
        return new DisciplineEntityServiceDefault();
    }
    @Bean @Scope() @Primary
    public SkillEntityService skillEntityService() {
        return new SkillEntityServiceDefault();
    }
}
