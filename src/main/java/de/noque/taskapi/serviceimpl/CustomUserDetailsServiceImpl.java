package de.noque.taskapi.serviceimpl;

import de.noque.taskapi.model.User;
import de.noque.taskapi.repository.UserRepository;
import de.noque.taskapi.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("User with the email: %s not found", email)));

        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            Collections.emptyList()
        );
    }
}
