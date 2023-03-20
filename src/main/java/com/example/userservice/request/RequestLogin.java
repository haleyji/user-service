package com.example.userservice.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestLogin {
    @NotNull(message = "Email can not be empty")
    @Valid
    private String email;

    @NotNull(message = "Password can not be empty")
    @Valid
    @Size(min = 5, max = 20, message = "Password can not be less than 5 letters")
    private String password;
}
