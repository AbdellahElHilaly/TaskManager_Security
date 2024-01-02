package com.youcode.taskmanager.core.adapter;

import com.youcode.taskmanager.core.database.model.dto.response.UserSingleResponse;
import com.youcode.taskmanager.core.database.model.entity.User;
import com.youcode.taskmanager.core.service.app.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final ModelMapper modelMapper;
    private final UserService userService;

    public List<UserSingleResponse> findAll() {
        List<User> users = userService.findAll();

        List<UserSingleResponse> userSingleResponses = new ArrayList<>();

        users.forEach(user -> {
            userSingleResponses.add(
                    modelMapper.map(user, UserSingleResponse.class)
            );
        });

        return userSingleResponses;

    }
}
