package com.youcode.taskmanager.core.database.model.dto.request;

import com.youcode.taskmanager.common.validation.annotaion.UUIDFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class TagRequest {

        @UUIDFormat
        private UUID id;

        @NotEmpty(message = "Name cannot be empty")
        @NotNull(message = "Name cannot be null")
        @Min(value = 2, message = "Name must be at least 2 characters")
        @Max(value =15, message = "Name must be at most 50 characters")
        private String name;

        @NotEmpty(message = "Description cannot be empty")
        @Min(value = 20, message = "Description must be at least 2 characters")
        @Max(value = 200, message = "Description must be at most 200 characters")
        private String description;
}
