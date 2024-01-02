package com.youcode.taskmanager.core.adapter;

import com.youcode.taskmanager.core.database.model.dto.request.TaskRequest;
import com.youcode.taskmanager.core.database.model.dto.response.TaskResponse;
import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.database.model.entity.User;
import com.youcode.taskmanager.core.service.app.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskAdapter {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskResponse save(TaskRequest taskRequest) {

        User assignedBy  = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Task task = modelMapper.map(taskRequest, Task.class);
        task.setAssignedBy(assignedBy);


        return modelMapper.map(
                taskService.save(task),
                TaskResponse.class
        );

    }


}
