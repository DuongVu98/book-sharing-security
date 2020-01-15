package com.hcmiu.bookssharingsecurity.usercases.interactors;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterInterator {

    @Autowired
    private UserJpaRepository userRepository;

    public User registerWithEmailAndPassword(User user){
        if(user != null){
            User oldUser = userRepository.findByEmail(user.getEmail());
            if(oldUser == null){
                return userRepository.save(user);
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
