package com.youcode.taskmanager.core.controller;

import com.youcode.taskmanager.core.adapter.TaskAdapter;
import com.youcode.taskmanager.core.database.model.dto.request.TaskRequest;
import com.youcode.taskmanager.core.database.model.dto.response.TaskResponse;
import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.service.app.TaskService;
import com.youcode.taskmanager.shared.Const.AppEndpoints;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(AppEndpoints.TASK)
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskAdapter taskAdapter;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid TaskRequest task) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskAdapter.save(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable UUID id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable UUID id, @RequestBody Task task) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(taskService.update(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}