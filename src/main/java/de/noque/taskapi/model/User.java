package de.noque.taskapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection
    private List<Long> projectIds = new ArrayList<>();;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public User(String name, String email, String username, String password, List<Long> projectIds) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.projectIds = projectIds != null ? new ArrayList<>(projectIds) : new ArrayList<>();
    }
}
