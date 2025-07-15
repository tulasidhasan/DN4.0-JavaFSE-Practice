package com.cognizant.springlearn.security;

import com.cognizant.springlearn.security.JwtAuthorizationFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Start password encoder");
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .inMemoryAuthentication()
                .withUser("user").password(encoder.encode("pwd")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("pwd")).roles("ADMIN")
                .and()
                .passwordEncoder(encoder)
                .and().build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/countries").hasRole("USER")
                .anyRequest().authenticated()
            )
            .addFilter(new JwtAuthorizationFilter(authManager))
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
