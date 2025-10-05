package com.zeezaglobal.BeanBarrelBackend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()) // no need for REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // REST = stateless
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/groups/**").permitAll() // ✅ open
                        .requestMatchers("/api/sales/**").permitAll()
                        .anyRequest().authenticated() // secure everything else
                )
                .httpBasic(Customizer.withDefaults()); // use Basic Auth (or replace with JWT later)

        return http.build();
    }
}
