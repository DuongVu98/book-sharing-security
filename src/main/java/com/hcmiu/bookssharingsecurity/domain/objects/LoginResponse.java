package com.hcmiu.bookssharingsecurity.domain.objects;

import com.hcmiu.bookssharingsecurity.domain.entities.User;
import lombok.Data;

@Data
public class LoginResponse {
    private User user;
    private String accessToken;
    private String tokenType = "Bearer";

    public LoginResponse(User user, String accessToken){
        this.user = user;
        this.accessToken = accessToken;
    }
}
