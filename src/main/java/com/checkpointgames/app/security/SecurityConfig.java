package com.checkpointgames.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // usado no cadastro e login
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desativa CSRF para testes via Postman
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/users/create", "/api/v1/auth/login").permitAll() // rotas públicas
                .anyRequest().authenticated() // o resto exige login
            );

        return http.build();
    }
}
