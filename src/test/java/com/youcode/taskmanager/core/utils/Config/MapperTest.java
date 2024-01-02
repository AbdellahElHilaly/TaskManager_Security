package com.youcode.taskmanager.core.utils.Config;

import com.youcode.taskmanager.core.database.model.dto.request.TaskRequest;
import com.youcode.taskmanager.core.database.model.dto.response.TaskResponse;
import com.youcode.taskmanager.core.database.model.entity.Tag;
import com.youcode.taskmanager.core.database.model.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class MapperTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void TaskRequestToTask() {
        Set<String> tagNames = new HashSet<>(Arrays.asList("tag1", "tag2"));
        TaskRequest taskRequest = TaskRequest.builder()
                .id(UUID.randomUUID())
                .title("task title")
                .description("task description")
                .content("task content")
                .tagNames(tagNames)
                .assignedToId(UUID.randomUUID())
                .build();

        Task task = modelMapper.map(taskRequest, Task.class);

    }

    @Test
    public void TaskToTaskResponse(){
        Tag tag_1 = Tag.builder()
                .id(UUID.randomUUID())
                .name("PHP")
                .description("tag description")
                .build();
        Tag tag_2 = Tag.builder()
                .id(UUID.randomUUID())
                .name("JAVA")
                .description("tag description")
                .build();

        Task task = Task.builder()
                .id(UUID.randomUUID())
                .content("task content")
                .title("task title")
                .description("task desciption")
                .tags(Arrays.asList(tag_1, tag_2))
                .build();

        TaskResponse taskResponse = modelMapper.map(task, TaskResponse.class);



    }



}
