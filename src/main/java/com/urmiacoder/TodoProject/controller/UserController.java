package com.urmiacoder.TodoProject.controller;


import com.urmiacoder.TodoProject.model.User;
import com.urmiacoder.TodoProject.repository.UserRepository;
import com.urmiacoder.TodoProject.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/userInformation")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @PostMapping("/userInformation")
    public User createUser(@Valid @RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/userInformation/{id}")
    public User updateUser(@PathVariable(value ="id")Long userId,@Valid @RequestBody User userDescriptions)
            throws UserNotFoundException {
        User user =
                userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        user.setName(userDescriptions.getName());
        User updateUser = userRepository.save(user);
        return updateUser;
    }
    @DeleteMapping("/userInformation/{id}")

    public void deleteUser(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        userRepository.delete(user);
    }

}