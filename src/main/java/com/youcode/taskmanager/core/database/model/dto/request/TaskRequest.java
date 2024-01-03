package com.youcode.taskmanager.core.database.model.dto.request;

import com.youcode.taskmanager.common.validation.annotaion.PresentOr2DaysFuture;
import com.youcode.taskmanager.common.validation.annotaion.UUIDFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class TaskRequest {

    @UUIDFormat
    private  UUID id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 4, max = 255, message = "Title must be between 4 and 255 characters")
    private  String title;

    @Size(min = 20, max = 1000, message = "Description must be between 20 and 1000 characters")
    private  String description;

    @Size(min = 50, max = 10000, message = "Content must be between 50 and 10000 characters")
    private  String content;

    @NotNull(message = "Start Date cannot be null")
    @FutureOrPresent(message = "Start Date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PresentOr2DaysFuture
    private LocalDate startDate;

    @NotNull(message = "Start Date cannot be null")
    @FutureOrPresent(message = "Start Date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotEmpty(message = "Tag Names list cannot be empty")
    @UniqueElements(message = "Tag Names list cannot contain repeated elements")
    @NotEmpty(message = "Tag Names list cannot be empty")
    private  Set<String> tagNames;

    @NotNull(message = "Assigned to id, cannot be null")
    @UUIDFormat
    private  UUID assignedToId;

}
