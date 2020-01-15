package com.hcmiu.bookssharingsecurity.adapters.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.hcmiu.bookssharingsecurity.domain.objects.FireUser;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth", method = RequestMethod.GET)
public class AuthenticationController {

    @Autowired
    Logger logger;

    @GetMapping("")
    public Map home(){
        return Collections.singletonMap("message", "Welcome to auth controller!!");
    }

    @PostMapping(value = "/login")
    public void login(){

    }

    @PostMapping(value = "/register")
    public UserRecord signUp(@RequestBody FireUser user) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setDisplayName(user.getDisplayName())
                .setDisabled(false);
        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
        logger.info("{New User} --> {}", userRecord.getUid());

        return userRecord;
    }

    @PostMapping(value = "/logout")
    public void logout(){

    }
}
