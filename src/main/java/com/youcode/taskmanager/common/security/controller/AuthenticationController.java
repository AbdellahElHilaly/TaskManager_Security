package com.youcode.taskmanager.common.security.controller;

import com.youcode.taskmanager.common.security.principal.dto.request.SignUpRequest;
import com.youcode.taskmanager.common.security.principal.dto.request.SigninRequest;
import com.youcode.taskmanager.common.security.principal.dto.response.JwtAuthenticationResponse;
import com.youcode.taskmanager.common.security.principal.dto.response.JwtRefreshTokenResponse;
import com.youcode.taskmanager.common.security.provider.jwt.service.auth.AuthenticationService;
import com.youcode.taskmanager.core.adapter.UserAdapter;
import com.youcode.taskmanager.core.database.model.dto.response.UserSingleResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/security")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserAdapter userAdapter;


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

//    ------------------------------ test ------------------------------
    @GetMapping("/me")
    public ResponseEntity<UserSingleResponse> getMe() {
        return ResponseEntity.ok(userAdapter.getMe());
    }

    @GetMapping
    public ResponseEntity<List<UserSingleResponse>> getAllUsers() {
        return ResponseEntity.ok(userAdapter.findAll());
    }


}