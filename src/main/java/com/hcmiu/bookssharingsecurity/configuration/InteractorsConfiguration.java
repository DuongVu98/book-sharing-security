package com.hcmiu.bookssharingsecurity.configuration;

import com.hcmiu.bookssharingsecurity.usercases.interactors.RegisterInterator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InteractorsConfiguration {

    @Bean
    public RegisterInterator registerInterator(){
        return new RegisterInterator();
    }
}
