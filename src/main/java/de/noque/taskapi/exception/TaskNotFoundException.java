package de.noque.taskapi.exception;

import de.noque.taskapi.model.Project;
import de.noque.taskapi.model.User;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Task with the id: " + id + " not found.");
    }

    public TaskNotFoundException(String taskNumber) {
        super("Task with the task-number: " + taskNumber + " not found.");
    }

    public TaskNotFoundException(Long projectId, Project project) {
        super("Task in the project with the id: " + projectId + " not found.");
    }

    public TaskNotFoundException(Long userId, User user) {
        super("Task from the user with the id: " + userId + " not found.");
    }

}
