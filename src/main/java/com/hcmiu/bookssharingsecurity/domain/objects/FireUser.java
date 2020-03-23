package com.hcmiu.bookssharingsecurity.domain.objects;

import lombok.Data;

@Data
public class FireUser {
    private String email;
    private String password;
    private String displayName;
}
