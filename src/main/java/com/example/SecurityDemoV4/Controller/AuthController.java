package com.example.SecurityDemoV4.Controller;

import javax.validation.Valid;

import com.example.SecurityDemoV4.Model.User;
import com.example.SecurityDemoV4.Payload.Request.LoginRequest;
import com.example.SecurityDemoV4.Payload.Response.LoginResponse;
import com.example.SecurityDemoV4.Repository.UserRepository;
import com.example.SecurityDemoV4.Security.Jwt.JwtTokenProvider;
import com.example.SecurityDemoV4.Service.CustomUserDetails;
import com.example.SecurityDemoV4.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 5/1/2019
 * Github: https://github.com/loda-kun
 */
@RestController
@RequestMapping("/api")
public class AuthController
{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/login")
    public LoginResponse authenticateUser( @RequestBody LoginRequest loginRequest) {

        // Xác thực thông tin người dùng Request lên
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public ResponseEntity<?> randomStuff(){
        return ResponseEntity.ok("hahahahS");
    }

//    @PostMapping("/addUser")
//    public ResponseEntity<?> add(@RequestBody LoginRequest loginRequest){
//        CustomUserDetails user = (CustomUserDetails) userService.loadUserById(loginRequest.ge);
//        return ResponseEntity.ok(user);
//    }
}
