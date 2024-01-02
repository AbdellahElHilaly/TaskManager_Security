package com.youcode.taskmanager.core.controller;

import com.youcode.taskmanager.core.adapter.UserAdapter;
import com.youcode.taskmanager.core.database.model.dto.response.UserSingleResponse;
import com.youcode.taskmanager.core.service.app.UserService;
import com.youcode.taskmanager.shared.Const.AppEndpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(AppEndpoints.USER)
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserAdapter userAdapter;


    @GetMapping
    public ResponseEntity<List<UserSingleResponse>> getAllUsers() {
        return ResponseEntity.ok(userAdapter.findAll());
    }





}
