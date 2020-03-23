package com.hcmiu.bookssharingsecurity.usercases.providers;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsernamePasswordDataAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Logger logger;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
            logger.info("authentication.getName() --> {}", authentication.getName());
            if(userDetails != null){
                if(userDetails.getUsername().equals(authentication.getName()) && userDetails.getPassword().equals(authentication.getCredentials().toString())){
                    return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), new ArrayList<>());
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }catch (UsernameNotFoundException e){
            logger.info("UsernameNotFoundException");
            throw e;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
