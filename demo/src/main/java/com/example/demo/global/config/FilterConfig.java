package com.example.demo.global.config;

import com.example.demo.global.error.ExceptionHandler;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Override
    public void configure(HttpSecurity builder) {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        builder.addFilterBefore(exceptionHandler, UsernamePasswordAuthenticationFilter.class);
    }
}
