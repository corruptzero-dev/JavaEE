package ru.corruptzero.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.corruptzero.lesson3.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByEmailAndPassword(String email, String password);
}

