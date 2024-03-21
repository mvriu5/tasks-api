package de.noque.taskapi.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task with the id: " + id + " not found.");
    }
}
