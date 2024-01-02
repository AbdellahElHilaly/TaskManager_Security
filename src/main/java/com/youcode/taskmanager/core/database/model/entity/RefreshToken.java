package com.youcode.taskmanager.core.database.model.entity;

import com.youcode.taskmanager.common.security.principal.dto.locale.UserDeviceInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String token;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String ipAddress;

    private String userAgent;


    public void setUserDeviceInfo(UserDeviceInfo userDeviceInfo) {
        this.ipAddress = userDeviceInfo.getIpAddress();
        this.userAgent = userDeviceInfo.getUserAgent();
    }

    public UserDeviceInfo getUserDeviceInfo() {
        return UserDeviceInfo.builder()
                .ipAddress(this.ipAddress)
                .userAgent(this.userAgent)
                .build();
    }

}