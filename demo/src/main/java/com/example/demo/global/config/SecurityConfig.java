package com.example.demo.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors().and()
                .csrf().disable()
                .formLogin().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.POST, "/board/create").permitAll()
                //.antMatchers(HttpMethod.GET, "/board/read/{id}").permitAll()
                .antMatchers(HttpMethod.PUT, "/board/update/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/board/delete/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/board/read").permitAll()
                .antMatchers(HttpMethod.GET, "/board/read/{id}").permitAll()

                .anyRequest().authenticated();

                /*
                .and()
                .apply(new FilterConfig(jwtTokenProvider));
                */
    }
}
