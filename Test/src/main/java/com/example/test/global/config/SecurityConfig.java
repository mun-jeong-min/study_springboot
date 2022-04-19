package com.example.test.global.config;

import com.example.test.global.security.jwt.JwtTokenProvider;
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

    private final JwtTokenProvider jwtTokenProvider;

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

                .antMatchers(HttpMethod.POST, "/crud/post").hasAuthority("USER")
                .antMatchers(HttpMethod.GET, "/crud/get").hasAuthority("USER")
                .antMatchers(HttpMethod.GET, "/crud/getOne/{id}").hasAuthority("USER")
                .antMatchers(HttpMethod.PUT, "/crud/put/{id}").hasAuthority("USER")
                .antMatchers(HttpMethod.DELETE, "/crud/delete/{id}").hasAuthority("USER")

                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()

                .anyRequest().authenticated()

                .and()
                .apply(new FilterConfig(jwtTokenProvider));
    }
}