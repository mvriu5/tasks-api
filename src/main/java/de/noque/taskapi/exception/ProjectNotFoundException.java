package de.noque.taskapi.exception;

import de.noque.taskapi.model.User;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Long id) {
        super("Project with the id: " + id + " not found.");
    }

    public ProjectNotFoundException(Long userId, User user) {
        super("Projects with the user-id: " + userId + " not found.");
    }
}
