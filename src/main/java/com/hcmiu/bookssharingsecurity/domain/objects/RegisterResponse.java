package com.hcmiu.bookssharingsecurity.domain.objects;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponse {
    private User user;
    private String message;
}
