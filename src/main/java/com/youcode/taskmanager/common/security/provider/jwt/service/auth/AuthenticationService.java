package com.youcode.taskmanager.common.security.provider.jwt.service.auth;

import com.youcode.taskmanager.common.security.principal.dto.request.SignUpRequest;
import com.youcode.taskmanager.common.security.principal.dto.request.SigninRequest;
import com.youcode.taskmanager.common.security.principal.dto.response.JwtAuthenticationResponse;
import com.youcode.taskmanager.common.security.principal.dto.response.JwtRefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {


    JwtAuthenticationResponse signup(SignUpRequest request, HttpServletRequest httpServletRequest);
    JwtAuthenticationResponse signin(SigninRequest request, HttpServletRequest httpServletRequest);





    JwtRefreshTokenResponse refresh(HttpServletRequest httpServletRequest);

    void logout(HttpServletRequest httpServletRequest);
}