package com.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication auth) {

        Instant now = Instant.now();
        Instant expirationTime = now.plus(7, ChronoUnit.DAYS);

        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expirationTime)
                .subject(auth.getName())
                .claim("roles", scope)
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    public Instant getExpirationFromToken(String token) throws Exception {
        try {
            // Ensure jwtDecoder is properly initialized before calling decode method
            if (jwtDecoder == null) {
                throw new Exception("JwtDecoder is not properly initialized.");
            }

            Jwt decodedJwt = jwtDecoder.decode(token);
            return decodedJwt.getExpiresAt();
        } catch (JwtException e) {
            // Handle JWT decoding exceptions
            throw new Exception("Invalid token");
        }
    }

}