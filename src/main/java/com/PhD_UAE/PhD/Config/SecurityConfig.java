package com.PhD_UAE.PhD.Config;

import com.PhD_UAE.PhD.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserServiceImp userService;
    @Autowired
    public SecurityConfig(@Lazy UserServiceImp userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/phd/auth/**", "/phd/candidat/create/**", "/phd/candidat/**", "/phd/candidat/getAll").permitAll()
                        .requestMatchers("/phd/auth/getuser/**", "/phd/auth/edit").permitAll()
                        .requestMatchers("/phd/auth/users/ced/").permitAll()
                        .requestMatchers("/phd/auth/login", "/phd/auth/register", "/phd/auth/getall", "phd/auth/test").permitAll()
                        .requestMatchers("/phd/auth/users/ced/").permitAll()
                        .requestMatchers("/phd/auth/getIdCandidate/**").permitAll()
                        .requestMatchers("/phd/auth/users/**","phd/Professeur/calltoentretien/**").permitAll()
                        .requestMatchers("/phd/Professeur/candidatesaccp/**","/phd/sujet/addsujet/**", "phd/sujet/getSujet/**", "phd/sujet/deleteSujet/**", "phd/sujet/updateSujet/**").permitAll()
                        .requestMatchers("/phd/Professeur/refusecandidat/**").permitAll()
                        .requestMatchers("/phd/Professeur/listentretien/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}