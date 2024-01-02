package com.youcode.taskmanager.core.database.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {

    private UUID id;

    private String title;
    private String description;
    private String content;

    private List<TagResponse> tags;

    private UserSingleResponse assignedTo;

    private UserSingleResponse assignedBy;


}
