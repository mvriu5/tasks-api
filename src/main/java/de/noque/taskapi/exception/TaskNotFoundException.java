package de.noque.taskapi.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super(String.format("Task with the id: %s not found.", id));
    }
}
