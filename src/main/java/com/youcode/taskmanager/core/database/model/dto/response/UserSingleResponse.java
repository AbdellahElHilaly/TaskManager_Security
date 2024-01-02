package com.youcode.taskmanager.core.database.model.dto.response;

import com.youcode.taskmanager.shared.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSingleResponse {


    private UUID id;

    private String firstName;
    private String lastName;

    private String email;

    private Role role;

}
