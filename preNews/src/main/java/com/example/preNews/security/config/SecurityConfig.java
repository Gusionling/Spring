package com.example.preNews.security.config;

import com.example.preNews.global.constrant.Constants;
import com.example.preNews.security.handler.jwt.JwtAuthEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    protected SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(registry ->
                        registry
                                .requestMatchers(Constants.NO_NEED_AUTH_URLS.toArray(String[]::new)).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(configure ->
                        configure.authenticationEntryPoint(jwtAuthEntryPoint)
                )
                .build();
    }

}
