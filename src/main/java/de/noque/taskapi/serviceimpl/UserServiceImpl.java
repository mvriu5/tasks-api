package de.noque.taskapi.serviceimpl;

import de.noque.taskapi.exception.UserNotFoundException;
import de.noque.taskapi.model.User;
import de.noque.taskapi.repository.UserRepository;
import de.noque.taskapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User userDb = get(id);

        userDb.setName(user.getName());
        userDb.setEmail(user.getEmail());
        userDb.setUsername(user.getUsername());
        userDb.setPassword(user.getPassword());
        userDb.setTimeCreated(user.getTimeCreated());

        return userRepository.save(userDb);
    }

    @Override
    public void delete(Long id) {
        get(id);
        userRepository.deleteById(id);
    }
}
