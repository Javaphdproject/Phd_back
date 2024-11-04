package com.PhD_UAE.PhD.Config;

import com.PhD_UAE.PhD.Entity.CED;
import com.PhD_UAE.PhD.Repository.CedRepository;
import com.PhD_UAE.PhD.Service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
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
                        .requestMatchers("/phd/auth/**").permitAll()
                        .requestMatchers("/phd/candidat/create/**", "/phd/candidat/**", "/phd/structures-recherche/create/**","/phd/etablissements/create/**").permitAll()
                        .requestMatchers("/phd/planning/create").permitAll()
                        .requestMatchers("/phd/planning/get", "/phd/auth/getuser/**", "/phd/aut").permitAll()
                        .requestMatchers("/phd/auth/users/ced/update-candidature-status/**","/phd/auth/users/ced/candidature/**", "/phd/auth/users/ced/file/", "/phd/auth/users/ced/add").permitAll()
                        .requestMatchers("/phd/auth/users/etablissements/all", "/phd/auth/users/professeurs/**/sujets").permitAll()
                        .requestMatchers("/phd/auth/getuser/**", "/phd/auth/edit").permitAll()
                        .requestMatchers("/phd/auth/users/ced/").permitAll()
                        .requestMatchers("/phd/Professeur/candidatesaccp/**").permitAll()
                        .requestMatchers("/phd/sujet/addsujet/**").permitAll()
                        //.requestMatchers("/phd/sujet/**").permitAll()
                        .requestMatchers("/phd/sujet/addsujet/**").permitAll()
                        .requestMatchers("/phd/sujet/updateSujet/**").permitAll()
                        .requestMatchers("/phd/Professeur/refusecandidat/**").permitAll()
                        .requestMatchers("/phd/Professeur/listentretien/**").permitAll()
                        .requestMatchers("/phd/Professeur/doctorant/**").permitAll()
                        .requestMatchers("/phd/Professeur/notecandidat/**").permitAll()
                        .requestMatchers("/phd/Professeur/generate-pdf").permitAll()
                        .requestMatchers("/phd/auth/users/candidat/**").permitAll()
                        .requestMatchers("/phd/candidature/get-all-sujets").permitAll()
                        .requestMatchers("/phd/candidature/add/**", "/phd/Professeur/calltoentretien/**").permitAll()
                        .requestMatchers("/phd/auth/getIdCandidate/**").permitAll()

                        .anyRequest().authenticated())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/phd/auth/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

}