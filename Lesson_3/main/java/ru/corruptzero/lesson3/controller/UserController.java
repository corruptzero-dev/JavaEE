package ru.corruptzero.lesson3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.corruptzero.lesson3.model.User;
import ru.corruptzero.lesson3.repository.UserRepository;
import ru.corruptzero.lesson3.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    @Autowired
    UserRepository repository;
    
    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> userData = userService.findById(id);
        return userData.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String username,
                                           @RequestParam String email,
                                           @RequestParam String password) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            User _user = userService.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,
                                           @RequestParam(required = false) String username,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(required = false) String password) {
        Optional<User> userData = userService.findById(id);
        if (userData.isPresent()) {
            User _user = userData.get();
            if (username != null) _user.setUsername(username);
            if (email != null) _user.setEmail(email);
            if (password != null) _user.setPassword(password);
            return new ResponseEntity<>(userService.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Error deleting user: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<User> patchResource(
            @PathVariable long id,
            @RequestBody User userData) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            boolean needUpdate = false;

            if (StringUtils.hasLength(userData.getUsername())) {
                user.setUsername(userData.getUsername());
                needUpdate = true;
            }
            if (StringUtils.hasLength(userData.getEmail())) {
                user.setEmail(userData.getEmail());
                needUpdate = true;
            }
            if (StringUtils.hasLength(userData.getPassword())) {
                user.setPassword(userData.getPassword());
                needUpdate = true;
            }
            if (needUpdate) {
                return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
