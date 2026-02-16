package br.com.personalproject.siseventos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests((authorize) -> authorize  
        .requestMatchers("/api/login/**", "/api/cadastro/**").permitAll()
        .anyRequest().hasAuthority("ROLE_FUNCIONARIO") 
        )

        .formLogin(form -> form
        .loginPage("/login")
        .defaultSuccessUrl("http://localhost:5173/cadastro",true)
        .permitAll()
         )

        .sessionManagement(session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        );
                    
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}