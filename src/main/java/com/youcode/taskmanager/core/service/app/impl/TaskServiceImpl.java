package com.youcode.taskmanager.core.service.app.impl;

import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.database.repository.TaskRepository;
import com.youcode.taskmanager.core.service.app.TaskService;
import com.youcode.taskmanager.core.service.app.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TagServiceImpl tagService;
    private final UserService userService;

    @Override
    public Task save(Task task) {

        task.setAssignedBy(userService.findById(task.getAssignedBy().getId()));
        task.setAssignedTo(userService.findById(task.getAssignedTo().getId()));

        CompletableFuture<Task> taskFuture = CompletableFuture.supplyAsync(
                () -> taskRepository.save(task)
        );

        CompletableFuture<Void> tagFuture = CompletableFuture.runAsync(() -> {
            task.getTags().forEach(tag -> {
                if(tagService.findByName(tag.getName()) != null) {
                    tag.setId(tagService.findByName(tag.getName()).getId());
                }
                tagService.save(tag);
            });
        });

        Task savedTask = null;
        try {
            savedTask = taskFuture.get(); // wait for the task to be saved
            tagFuture.get(); // wait for the tags to be saved
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return savedTask;
    }

    @Override
    public Task findById(UUID uuid) {
        return findByIdOrThrow(uuid);
    }

    @Override
    public Task update(UUID id , Task task) {
        findByIdOrThrow(id);
        task.setId(id);
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(UUID uuid) {
        taskRepository.delete(findByIdOrThrow(uuid));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    private Task findByIdOrThrow(UUID uuid) {
        return taskRepository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("Task not found with id: " + uuid)
        );
    }
}
