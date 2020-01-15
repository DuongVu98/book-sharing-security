package com.hcmiu.bookssharingsecurity.domain.exceptions;

import javax.naming.AuthenticationException;

public class UsernameOrEmailAlreadyExistAuthenticationException extends AuthenticationException {
    public UsernameOrEmailAlreadyExistAuthenticationException(final String message){
        super(message);
    }
}
