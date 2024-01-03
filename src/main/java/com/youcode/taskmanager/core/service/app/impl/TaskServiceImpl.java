package com.youcode.taskmanager.core.service.app.impl;

import com.youcode.taskmanager.core.database.model.entity.Tag;
import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.database.repository.TaskRepository;
import com.youcode.taskmanager.core.service.app.TaskService;
import com.youcode.taskmanager.core.service.app.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

        List<Tag> tagsToHandel = new ArrayList<>();
        task.getTags().forEach(tag -> {
            Tag tempTag = tagService.findByName(tag.getName());
            if(tempTag != null){
                tagsToHandel.add(tempTag);
            }
            else tagsToHandel.add(tagService.save(tag));
        });
        task.setTags(tagsToHandel);
        return taskRepository.save(task);
    }

    @Override
    public Task findById(UUID uuid) {
        return findByIdOrThrow(uuid);
    }

    @Override
    public Task update(UUID id, Task task) {
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
