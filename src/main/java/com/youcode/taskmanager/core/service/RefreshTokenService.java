package com.youcode.taskmanager.core.service;

import com.youcode.taskmanager.core.database.model.entity.RefreshToken;

public interface RefreshTokenService {
    RefreshToken save(RefreshToken refreshToken);
    RefreshToken findByToken(String refreshToken);
}