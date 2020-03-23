package com.hcmiu.bookssharingsecurity.usercases.services;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.repositories.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserSecurityService implements UserDetailsService {


    @Autowired
    UserJpaRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }

        log.info("{User} --> username: {}, password: {}", user.getUsername(), user.getPassword());
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(String userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("Username not found with Id: "+userId));
        return new CustomUserDetails(user);
    }
}
