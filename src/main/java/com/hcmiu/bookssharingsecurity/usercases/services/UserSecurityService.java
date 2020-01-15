package com.hcmiu.bookssharingsecurity.usercases.services;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.repositories.UserJpaRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    Logger logger;

    @Autowired
    UserJpaRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        logger.info("{User} --> username: {}, password: {}", user.getUsername(), user.getPassword());
        return new CustomUserDetails(user);
    }
}
