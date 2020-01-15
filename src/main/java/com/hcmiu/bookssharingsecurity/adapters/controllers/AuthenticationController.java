package com.hcmiu.bookssharingsecurity.adapters.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.hcmiu.bookssharingsecurity.domain.objects.FireUser;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginRequest;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginResponse;
import com.hcmiu.bookssharingsecurity.usercases.firebaseservices.FirebaseUserManagement;
import com.hcmiu.bookssharingsecurity.usercases.interactors.LoginInteractor;
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

    @Autowired
    private FirebaseUserManagement firebaseUserManagement;

    @Autowired
    private LoginInteractor loginInteractor;

    @GetMapping("")
    public Map home(){
        return Collections.singletonMap("message", "Welcome to auth controller!!");
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginInteractor.authenticateUser(loginRequest);
    }

    @PostMapping(value = "/register")
    public UserRecord signUp(@RequestBody FireUser user) throws FirebaseAuthException {
        return this.firebaseUserManagement.createUser(user);
    }

    @PostMapping(value = "/logout")
    public void logout(){

    }
}
