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
    private Long Id;

    private String TaskNumber;

    @Column(nullable = false)
    private Label Label;

    @Column(nullable = false)
    private String Task;

    @Column(nullable = false)
    private Status Status;

    @Column(nullable = false)
    private Priority Priority;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime TimeCreated;

    public Task( Label label, String task, Status status, Priority priority) {
        this.TaskNumber = "TASK-" + this.Id;
        this.Label = label;
        this.Task = task;
        this.Status = status;
        this.Priority = priority;
    }
}
