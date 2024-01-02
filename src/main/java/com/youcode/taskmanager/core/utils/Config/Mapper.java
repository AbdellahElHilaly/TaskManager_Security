package com.youcode.taskmanager.core.utils.Config;

import com.youcode.taskmanager.common.security.principal.dto.request.SignUpRequest;
import com.youcode.taskmanager.core.database.model.dto.request.TaskRequest;
import com.youcode.taskmanager.core.database.model.dto.response.TaskResponse;
import com.youcode.taskmanager.core.database.model.dto.response.UserSingleResponse;
import com.youcode.taskmanager.core.database.model.entity.Tag;
import com.youcode.taskmanager.core.database.model.entity.Task;
import com.youcode.taskmanager.core.database.model.entity.User;
import com.youcode.taskmanager.shared.Enum.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class Mapper {

    private final PasswordEncoder passwordEncoder;

    @Configuration
    public class ModelMapperConfig {
        @Bean
        public ModelMapper modelMapper() {

            ModelMapper modelMapper = new ModelMapper();

            userRequestToUser(modelMapper);

            taskRequestToTask(modelMapper);

            taskToTaskResponse(modelMapper);

            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper;
        }
    }


    private void userRequestToUser(ModelMapper modelMapper) {
        Converter<String, String> passwordEncoderConverter = context -> {
            String sourcePassword = context.getSource();
            return passwordEncoder.encode(sourcePassword);
        };

        modelMapper.createTypeMap(SignUpRequest.class, User.class)
                .addMappings(mapper -> mapper.using(passwordEncoderConverter)
                        .map(SignUpRequest::getPassword, User::setPassword))
                .setPostConverter(context -> {
                    User user = context.getDestination();
                    user.setRole(Role.USER);
                    return user;
                });
    }

    private void taskRequestToTask(ModelMapper modelMapper) {

        modelMapper.createTypeMap(TaskRequest.class, Task.class).setPostConverter(context -> {

            User assignedTo = User.builder()
                    .id(context.getSource().getAssignedToId())
                    .build();


            context.getDestination().setAssignedTo(assignedTo);




            Task task = context.getDestination();
            List<Tag> tags = context.getSource().getTagNames().stream()
                    .map(tagName -> Tag.builder().name(tagName).build())
                    .collect(Collectors.toList());
            task.setTags(tags);
            return task;
        });

    }

    private void taskToTaskResponse(ModelMapper modelMapper) {

        modelMapper.createTypeMap(Task.class, TaskResponse.class).setPostConverter(context -> {

            TaskResponse taskResponse = context.getDestination();

            taskResponse.setAssignedTo(UserSingleResponse.builder()
                    .id(context.getSource().getAssignedTo().getId())
                    .firstName(context.getSource().getAssignedTo().getFirstName())
                    .lastName(context.getSource().getAssignedTo().getLastName())
                    .email(context.getSource().getAssignedTo().getEmail())
                    .role(context.getSource().getAssignedTo().getRole())
                    .build());

            taskResponse.setAssignedBy(UserSingleResponse.builder()
                    .id(context.getSource().getAssignedBy().getId())
                    .firstName(context.getSource().getAssignedBy().getFirstName())
                    .lastName(context.getSource().getAssignedBy().getLastName())
                    .email(context.getSource().getAssignedTo().getEmail())
                    .role(context.getSource().getAssignedTo().getRole())
                    .build());

            return taskResponse;

        });
    }

}
