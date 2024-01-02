package com.youcode.taskmanager.core.service.app;

import com.youcode.taskmanager.core.database.model.dto.response.UserSingleResponse;
import com.youcode.taskmanager.core.database.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User save(User user);

    User findByEmail(String email);

    List<User> findAll();

    User findById(UUID id);
}
