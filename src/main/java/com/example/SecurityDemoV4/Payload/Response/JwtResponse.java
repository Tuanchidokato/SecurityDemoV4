package com.example.SecurityDemoV4.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String accessToken;
//    private String type ="Bearer";
//    private long id;
//    private String username;
//    private String email;
}
