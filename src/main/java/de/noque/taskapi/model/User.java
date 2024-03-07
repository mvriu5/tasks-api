package de.noque.taskapi.model;

import de.noque.taskapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "Users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String Email;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private Role Role;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime TimeCreated;

    public User(String email, String password, Role role) {
        this.Email = email;
        this.Password = password;
        this.Role = role;
    }
}
