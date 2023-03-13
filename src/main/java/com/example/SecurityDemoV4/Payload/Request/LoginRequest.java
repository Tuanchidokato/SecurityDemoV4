package com.example.SecurityDemoV4.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class LoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;


}
