package com.hcmiu.bookssharingsecurity.domain.objects;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {
    @NotBlank(message = "email cannot be null")
    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "password cannot be null")
    @Size(min = 6, message = "password must be at least 6 characters")
    private String password;

    @NotBlank(message = "please fill this to confirm password")
    private String confirmPassword;
}
