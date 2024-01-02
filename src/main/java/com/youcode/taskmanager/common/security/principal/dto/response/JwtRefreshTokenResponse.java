package com.youcode.taskmanager.common.security.principal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRefreshTokenResponse {
    private String accessToken;
}
