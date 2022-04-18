package com.example.test.global.config;

import com.example.test.global.enums.Authority;
import com.example.test.global.error.ExceptionHandler;
import com.example.test.global.security.jwt.JwtTokenFilter;
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

                .antMatchers(HttpMethod.POST, "/crud/post").authenticated()
                .antMatchers(HttpMethod.GET, "/crud/get").authenticated()
                .antMatchers(HttpMethod.PUT, "/crud/put/{id}").authenticated()
                .antMatchers(HttpMethod.DELETE, "/crud/delete/{id}").authenticated()

                .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                .antMatchers(HttpMethod.POST, "/user/login").permitAll()

                .anyRequest().authenticated() // anymatchers에 적용되지 않은 모든 url

                .and()
                .apply(new FilterConfig(jwtTokenProvider));
    }
}
