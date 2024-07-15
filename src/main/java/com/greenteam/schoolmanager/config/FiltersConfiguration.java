package com.greenteam.schoolmanager.config;

import com.greenteam.schoolmanager.filters.ValidateTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FiltersConfiguration {

    @Autowired
    ValidateTokenFilter validateTokenFilter;

    @Bean @Scope()
    protected FilterRegistrationBean<ValidateTokenFilter> validateToken() {

        FilterRegistrationBean<ValidateTokenFilter> filter = new FilterRegistrationBean<ValidateTokenFilter>();
        filter.setFilter(validateTokenFilter);
        filter.addUrlPatterns("/*");

        return filter;
    }
}
