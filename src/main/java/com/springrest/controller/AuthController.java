package com.springrest.controller;


import com.springrest.request.SignInRequest;
import com.springrest.request.SignUpRequest;
import com.springrest.response.SignInResponse;
import com.springrest.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    public AuthService authService;

    @PostMapping("/signUp")
    public String signUp(@RequestBody SignUpRequest request) {
        authService.signUp(request);
        return "User created successfully!";
    }

    @PostMapping("/signIn")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        return authService.signIn(request);
//        return null;
    }

    @PostMapping("/testing")
    public String testing(@RequestBody SignInRequest request) {
        return "authService.signIn(request)";
    }

}
