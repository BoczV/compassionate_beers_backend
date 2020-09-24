package com.codecool.userservice.controller;

import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping
public class SaveUserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String saveUser(@RequestBody Map<String, Object> requestBody) {
         User user = (User) requestBody.get("user");
        userRepository.save(user);
        return "Ok";
    }
}
