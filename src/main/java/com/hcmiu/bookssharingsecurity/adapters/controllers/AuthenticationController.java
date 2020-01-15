package com.hcmiu.bookssharingsecurity.adapters.controllers;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.exceptions.RegisterException;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginRequest;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginResponse;
import com.hcmiu.bookssharingsecurity.domain.objects.RegisterRequest;
import com.hcmiu.bookssharingsecurity.domain.objects.RegisterResponse;
import com.hcmiu.bookssharingsecurity.usercases.firebaseservices.FirebaseUserManagement;
import com.hcmiu.bookssharingsecurity.usercases.interactors.LoginInteractor;
import com.hcmiu.bookssharingsecurity.usercases.interactors.RegisterInterator;
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
    @Autowired
    private RegisterInterator registerInterator;

    @GetMapping("")
    public Map home(){
        return Collections.singletonMap("message", "Welcome to auth controller!!");
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return loginInteractor.authenticateUser(loginRequest);
    }

    @PostMapping(value = "/register")
    public RegisterResponse signUp(@RequestBody RegisterRequest registerRequest) {
        try {
            User newUser = registerInterator.registerWithEmailAndPassword(registerRequest);
            return new RegisterResponse(newUser, "register success");
        } catch (RegisterException e) {
            return new RegisterResponse(null, e.getMessage());
        }
    }

    @PostMapping(value = "/logout")
    public void logout(){

    }
}
