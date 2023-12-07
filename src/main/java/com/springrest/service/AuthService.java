package com.springrest.service;

import com.springrest.entity.UserInfo;
import com.springrest.repository.UserInfoRepository;
import com.springrest.request.SignInRequest;
import com.springrest.request.SignUpRequest;
import com.springrest.response.SignInResponse;
import com.springrest.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
public class AuthService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserInfoRepository userDetailsRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager manager;

    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SignInResponse signUp(SignUpRequest request) {
        // Encode the password before saving it in the database
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        UserInfo user = UserInfo.builder()
                .email(request.getEmail())
                .password(encodedPassword) // Save the encoded password
                .build();

        userService.createUser(user);
        return null;
    }

    public SignInResponse signIn(SignInRequest request) {
//        UserInfo userDetails = userDetailsRepository.findByEmail(request.getEmail());
        UserInfo userDetails = userDetailsRepository.findById(2).get();

        if (userDetails != null && passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
            // Assuming userDetails is fetched correctly and the password matches
            String token = jwtService.generateToken(userDetails);

            SignInResponse response = SignInResponse.builder()
                    .jwtToken(token)
                    .email(userDetails.getEmail())
                    .build();

            return response;
        } else {
            // Handle incorrect credentials or user not found
            throw new BadCredentialsException("Invalid credentials");
        }
    }
    //        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

//        String token = jwtService.generateToken(userDetails);

//        SignInResponse response = SignInResponse.builder().jwtToken(token).email(userDetails.getEmail()).build();
//        return response;

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
