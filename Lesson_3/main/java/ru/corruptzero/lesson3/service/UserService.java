package ru.corruptzero.lesson3.service;

import ru.corruptzero.lesson3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> getAllUsers();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
