package com.youcode.taskmanager.core.service.app;

import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.service.app.CrudService;

import java.util.UUID;

public interface TaskService extends CrudService<Task, UUID> {
}
