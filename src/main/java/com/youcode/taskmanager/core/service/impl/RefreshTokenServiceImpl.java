package com.youcode.taskmanager.core.service.impl;

import com.youcode.taskmanager.core.database.model.entity.RefreshToken;
import com.youcode.taskmanager.core.database.repository.RefreshTokenRepository;
import com.youcode.taskmanager.core.service.RefreshTokenService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken findByToken(String refreshToken) {
        return findByTokenOrThrow(refreshToken);
    }

    private RefreshToken findByTokenOrThrow(String token) {
        return refreshTokenRepository.findByToken(token)
                .orElseThrow(() -> new NoSuchElementException("Could not find refresh token"));
    }

}