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
    private String name;

    private String description;

    @OneToOne
    @Column(nullable = false)
    private User creator;

    @ManyToMany
    private Set<User> users = new HashSet<>();

    @OneToMany
    private Set<Task> tasks = new HashSet<>();

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Project(String name, String description, User creator, Set<User> users, Set<Task> tasks) {
        this.name = name;
        this.description = description;
        this.creator = creator;
        this.users = users;
        this.tasks = tasks;
    }
}
