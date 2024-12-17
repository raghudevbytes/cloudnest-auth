package com.cloudnest.auth.config;

import com.cloudnest.auth.providers.CustomAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@Order(1)
public class SecurityConfig {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    public SecurityConfig(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        log.info("Configuring SecurityFilterChain");
        http.httpBasic(Customizer.withDefaults());
       // http.authenticationManager(new ProviderManager(customAuthenticationProvider));
       http.authenticationProvider(customAuthenticationProvider);
        http.authorizeHttpRequests(
                request->{request.anyRequest().permitAll();
                }
        );

        return http.build();
    }
   /* @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        log.info("Configuring AuthenticationManager");
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(customAuthenticationProvider)
                .build();
    }*/
}
