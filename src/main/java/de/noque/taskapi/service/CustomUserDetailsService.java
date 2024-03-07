package de.noque.taskapi.service;

import de.noque.taskapi.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface CustomUserDetailsService {

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
