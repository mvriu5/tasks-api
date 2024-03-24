package de.noque.taskapi.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User with the id: " + id + " not found.");
    }

    public UserNotFoundException(String name) {
        super("User with the username/email: " + name + " not found.");
    }
}
