package com.youcode.taskmanager.core.utils.Config;

import com.youcode.taskmanager.core.adapter.TaskAdapter;
import com.youcode.taskmanager.core.service.app.TaskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Beans {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

//    @Bean
//    public TaskAdapter taskAdapter(){
//        return new TaskAdapter(taskService, modelMapper);
//    }

}
