package com.codecool.userservice.controller;

import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class SaveUserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Ok";
    }

    @GetMapping("/get/{username}")
    public User getUser(@PathVariable String username){
        return userRepository.findByUserName(username).get();
    }
}
