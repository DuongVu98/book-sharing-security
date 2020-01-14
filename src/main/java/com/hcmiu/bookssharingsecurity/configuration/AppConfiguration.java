package com.hcmiu.bookssharingsecurity.configuration;

import com.hcmiu.bookssharingsecurity.usercases.providers.UsernamePasswordAuthenticationCustomProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;

@Configuration
public class AppConfiguration {

    @Bean
    @Primary
    public AuthenticationProvider usernamePasswordAuthenticationCustomProvider(){
        return new UsernamePasswordAuthenticationCustomProvider();
    }

    @Bean
    public Logger getLogger() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        return logger;
    }
}
