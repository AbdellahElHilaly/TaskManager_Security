package com.youcode.taskmanager.common.security.filter;

import com.youcode.taskmanager.common.security.provider.jwt.service.auth.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class RefreshTokenFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;

    public RefreshTokenFilter(AuthenticationService authenticationService, AuthenticationManager authenticationManager) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String refreshToken = extractRefreshToken(request);

        if (refreshToken != null) {
            authenticationService.refresh(request);
        }

        chain.doFilter(request, response);
    }


    private String extractRefreshToken(HttpServletRequest request) {
        // Extract the refresh token from the request headers, cookies, or parameters
        // You can implement the logic to extract the refresh token based on your application's design
        return null; // Replace this with your implementation
    }
}

