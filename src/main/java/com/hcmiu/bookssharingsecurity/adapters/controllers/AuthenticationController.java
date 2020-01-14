package com.hcmiu.bookssharingsecurity.adapters.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", method = RequestMethod.GET)
public class AuthenticationController {

    @PostMapping(value = "/login")
    public void login(){

    }

    @PostMapping(value = "/resigter")
    public void signUp(){

    }

    @PostMapping(value = "/logout")
    public void logout(){

    }
}
