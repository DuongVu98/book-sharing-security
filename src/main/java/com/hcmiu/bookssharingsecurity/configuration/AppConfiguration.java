package com.hcmiu.bookssharingsecurity.configuration;

import com.hcmiu.bookssharingsecurity.usercases.providers.UsernamePasswordAuthenticationCustomProvider;
import com.hcmiu.bookssharingsecurity.usercases.providers.UsernamePasswordDataAuthenticationProvider;
import com.hcmiu.bookssharingsecurity.usercases.services.JwtAuthorizationFilter;
import com.hcmiu.bookssharingsecurity.usercases.services.JwtTokenService;
import com.hcmiu.bookssharingsecurity.usercases.services.UserSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class AppConfiguration {

    @Bean
    public JwtTokenService jwtTokenService(){
        return new JwtTokenService();
    }

    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(){
        return new JwtAuthorizationFilter();
    }

    @Bean(name = "non-data")
    public AuthenticationProvider usernamePasswordAuthenticationCustomProvider(){
        return new UsernamePasswordAuthenticationCustomProvider();
    }

    @Bean(name = "user-data")
    public AuthenticationProvider usernamePasswordAuthenticationDataProvider(){
        return new UsernamePasswordDataAuthenticationProvider();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserSecurityService();
    }

    @Bean
    public Logger getLogger() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        return logger;
    }
}
