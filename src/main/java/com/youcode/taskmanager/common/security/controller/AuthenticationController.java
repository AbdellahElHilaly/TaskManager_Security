package com.youcode.taskmanager.common.security.controller;

import com.youcode.taskmanager.common.security.dto.request.SignUpRequest;
import com.youcode.taskmanager.common.security.dto.request.SigninRequest;
import com.youcode.taskmanager.common.security.dto.response.JwtAuthenticationResponse;
import com.youcode.taskmanager.common.security.dto.response.JwtRefreshTokenResponse;
import com.youcode.taskmanager.common.security.provider.jwt.service.auth.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest signUpRequest, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequest, httpServletRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.signin(request, httpServletRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtRefreshTokenResponse> refresh(HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(authenticationService.refresh(httpServletRequest));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest httpServletRequest) {
        authenticationService.logout(httpServletRequest);
        return ResponseEntity.ok().build();
    }


}