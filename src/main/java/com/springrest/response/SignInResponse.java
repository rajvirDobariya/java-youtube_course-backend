package com.springrest.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponse {
    private String email;
    private String jwtToken;
}
