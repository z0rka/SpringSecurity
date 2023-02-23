package com.example.springsecurity.security;

import com.example.springsecurity.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security app configuration
 *
 * @author z0rka 13.02.2023
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public static final String WELCOME_LINK = "/welcome";
    public static final String LOGIN_LINK = "/login";

    @Autowired
    @Lazy
    private UserDetailsService userDetailsService;

    /**
     * Encoder
     */
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * authenticationProvide
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder());
        return authenticationProvider;
    }

    /**
     * Filter for security
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/ping", LOGIN_LINK, "/user").permitAll()
                        .requestMatchers("/products").hasRole(UserRole.ADMIN.name())
                        .requestMatchers("/info", WELCOME_LINK).hasAnyRole(UserRole.DEFAULT.name(),
                                UserRole.ADMIN.name())
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage(LOGIN_LINK)
                        .loginProcessingUrl(LOGIN_LINK)
                        .defaultSuccessUrl(WELCOME_LINK, true)
                        .permitAll()
                )
                .exceptionHandling().accessDeniedPage("/403").and()
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}
