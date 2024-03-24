package de.noque.taskapi.service;

import de.noque.taskapi.model.User;

public interface UserService {

    User get(Long id);

    User getByEmail(String email);

    User getByUsername(String username);

    User create(User user);

    User update(Long id, User user);

    void delete(Long id);

}
