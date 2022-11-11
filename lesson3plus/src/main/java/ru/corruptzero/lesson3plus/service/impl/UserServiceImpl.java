package ru.corruptzero.lesson3plus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.corruptzero.lesson3plus.model.User;
import ru.corruptzero.lesson3plus.repository.UserRepository;
import ru.corruptzero.lesson3plus.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return new ArrayList<>(userRepository.findAll());
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}