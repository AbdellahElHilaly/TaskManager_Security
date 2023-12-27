package com.youcode.taskmanager.common.security.provider.jwt.service.token;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);

    String generaAccessToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}