package de.noque.taskapi.model;

import de.noque.taskapi.model.enums.Label;
import de.noque.taskapi.model.enums.Priority;
import de.noque.taskapi.model.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Tasks")
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Column(nullable = false)
    private User user;

    private String taskNumber;

    @ManyToOne
    @Column(nullable = false)
    private Project project;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false)
    private Label label;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Priority priority;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Task(User user, Project project, String title, String description, Label label, Status status, Priority priority) {
        this.user = user;
        this.project = project;
        this.title = title;
        this.description = description;
        this.label = label;
        this.status = status;
        this.priority = priority;
    }

    @PostPersist
    public void setTaskNumber() {
        this.taskNumber = "TASK-" + this.id;
    }
}
