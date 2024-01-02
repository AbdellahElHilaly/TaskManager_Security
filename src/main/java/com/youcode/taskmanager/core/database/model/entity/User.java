package com.youcode.taskmanager.core.database.model.entity;

import com.youcode.taskmanager.shared.Enum.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "assignedTo")
    @ToString.Exclude
    private List<Task> tasksAssigned;

    @OneToMany(mappedBy = "assignedBy")
    @ToString.Exclude
    private List<Task> tasksAssignedBy;

}

