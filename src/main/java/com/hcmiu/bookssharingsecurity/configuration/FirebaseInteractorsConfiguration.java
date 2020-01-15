package com.hcmiu.bookssharingsecurity.configuration;

import com.hcmiu.bookssharingsecurity.usercases.firebaseservices.FirebaseUserManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseInteractorsConfiguration {

    @Bean
    public FirebaseUserManagement firebaseUserManagement(){
        return new FirebaseUserManagement();
    }
}
