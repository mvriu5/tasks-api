package de.noque.taskapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Projects")
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long parentUserId;

    private String description;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Project(String name, String description, Long parentUserId) {
        this.name = name;
        this.description = description;
        this.parentUserId = parentUserId;
    }
}
