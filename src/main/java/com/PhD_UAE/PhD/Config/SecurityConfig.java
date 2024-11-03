package com.PhD_UAE.PhD.Config;

import com.PhD_UAE.PhD.Service.UserServiceImp;
import com.PhD_UAE.PhD.Config.JwtRequestFilter;
import jakarta.servlet.Filter;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserServiceImp userService;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(@Lazy UserServiceImp userService, @Lazy JwtRequestFilter jwtRequestFilter) {
        this.userService = userService;
        this.jwtRequestFilter = jwtRequestFilter;
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
                        .requestMatchers("/phd/auth/users/login", "/phd/auth/users/register").permitAll()
                        .requestMatchers("/phd/auth/users/candidat/create/**").hasAuthority("CED")
                        .requestMatchers("/phd/auth/users/professeurs/**").hasAuthority("CED")
                        .requestMatchers("/phd/auth/users/structures-recherche/create/**").hasAuthority("CED")
                        .requestMatchers("/phd/auth/users/etablissements/create/**", "/phd/auth/users/etablissements/all").hasAuthority("CED")
                        .requestMatchers("/phd/auth/users/candidat/getAll")
                        .hasAnyAuthority("PROFESSEUR", "CED")
                        .requestMatchers("/phd/auth/users/candidat/**").hasAnyAuthority("CANDIDAT", "CED","PROFESSEUR")
                        .requestMatchers("/phd/planning/create").hasAuthority("CED")
                        .requestMatchers("/phd/planning/get").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
}
