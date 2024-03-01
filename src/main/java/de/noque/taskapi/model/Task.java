package de.noque.taskapi.model;

import de.noque.taskapi.model.enums.Label;
import de.noque.taskapi.model.enums.Priority;
import de.noque.taskapi.model.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Tasks")
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

    public Task() {}

    public Task( Label label, String task, Status status, Priority priority) {
        this.TaskNumber = "TASK-" + this.Id;
        this.Label = label;
        this.Task = task;
        this.Status = status;
        this.Priority = priority;
    }

    //<editor-fold desc="Getter & Setter">
    public Long getId() {
        return Id;
    }

    public String getTaskNumber() {
        return TaskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        TaskNumber = taskNumber;
    }

    public de.noque.taskapi.model.enums.Label getLabel() {
        return Label;
    }

    public void setLabel(de.noque.taskapi.model.enums.Label label) {
        Label = label;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public de.noque.taskapi.model.enums.Status getStatus() {
        return Status;
    }

    public void setStatus(de.noque.taskapi.model.enums.Status status) {
        Status = status;
    }

    public de.noque.taskapi.model.enums.Priority getPriority() {
        return Priority;
    }

    public void setPriority(de.noque.taskapi.model.enums.Priority priority) {
        Priority = priority;
    }

    public LocalDateTime getTimeCreated() {
        return TimeCreated;
    }
    //</editor-fold>
}
