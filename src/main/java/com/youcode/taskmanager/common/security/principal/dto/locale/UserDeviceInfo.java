package com.youcode.taskmanager.common.security.principal.dto.locale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDeviceInfo {
    private String ipAddress;
    private String userAgent;
}
