package com.youcode.taskmanager.core.service.app;

import com.youcode.taskmanager.core.database.model.entity.RefreshToken;
import com.youcode.taskmanager.core.database.model.entity.User;

public interface RefreshTokenService {
    RefreshToken save(RefreshToken refreshToken);
    RefreshToken findByToken(String refreshToken);
    RefreshToken findByUser(User user);
    RefreshToken update(RefreshToken refreshToken);
    void delete(RefreshToken refreshToken);
}