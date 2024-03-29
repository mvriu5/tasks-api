package de.noque.taskapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Projects")
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long creatorId;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany
    private Set<User> users = new HashSet<>();

    @OneToMany
    private Set<Task> tasks = new HashSet<>();

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Project(Long creatorId, String name, String description, Set<User> users, Set<Task> tasks) {
        this.creatorId = creatorId;
        this.name = name;
        this.description = description;
        this.users = users;
        this.tasks = tasks;
    }
}
