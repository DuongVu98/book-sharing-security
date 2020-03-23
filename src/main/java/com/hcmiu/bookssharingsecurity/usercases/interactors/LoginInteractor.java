package com.hcmiu.bookssharingsecurity.usercases.interactors;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginRequest;
import com.hcmiu.bookssharingsecurity.domain.objects.LoginResponse;
import com.hcmiu.bookssharingsecurity.domain.repositories.UserJpaRepository;
import com.hcmiu.bookssharingsecurity.usercases.services.CustomUserDetails;
import com.hcmiu.bookssharingsecurity.usercases.services.JwtTokenService;
import com.hcmiu.bookssharingsecurity.usercases.services.UserSecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@Slf4j
public class LoginInteractor {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userSecurityService;

    @Autowired
    UserJpaRepository userRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenService.generateToken((CustomUserDetails) userSecurityService.loadUserByUsername(authentication.getName()));
        User user = userRepository.findByEmail(authentication.getName());

        log.info("getAuthentication.getName() --> {}", authentication.getName());
        return new LoginResponse(user, jwt);
    }
}
