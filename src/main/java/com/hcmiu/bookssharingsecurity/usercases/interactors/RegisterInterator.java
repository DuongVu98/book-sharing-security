package com.hcmiu.bookssharingsecurity.usercases.interactors;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.exceptions.UsernameOrEmailAlreadyExistAuthenticationException;
import com.hcmiu.bookssharingsecurity.domain.objects.RegisterRequest;
import com.hcmiu.bookssharingsecurity.domain.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RegisterInterator {

    @Autowired
    private UserJpaRepository userRepository;

    public User registerWithEmailAndPassword(@Valid RegisterRequest registerRequest) throws UsernameOrEmailAlreadyExistAuthenticationException {
        User oldUser = userRepository.findByEmail(registerRequest.getEmail());
        if (oldUser == null) {
            User newUser = new User(registerRequest.getEmail(), registerRequest.getPassword());
            return userRepository.save(newUser);
        } else {
            throw new UsernameOrEmailAlreadyExistAuthenticationException("username or email has already existed");
        }
    }
}
