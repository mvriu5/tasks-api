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

    private String taskNumber;

    @Column(nullable = false)
    private Label label;

    @Column(nullable = false)
    private String task;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Priority priority;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeCreated;

    public Task( Label label, String task, Status status, Priority priority) {
        this.label = label;
        this.task = task;
        this.status = status;
        this.priority = priority;
    }

    @PostPersist
    public void setTaskNumber() {
        this.taskNumber = "TASK-" + this.id;
    }
}
