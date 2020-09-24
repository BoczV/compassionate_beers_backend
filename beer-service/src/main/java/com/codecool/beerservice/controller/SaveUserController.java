package com.codecool.beerservice.controller;

import com.codecool.beerservice.service.UserServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/save-user")
public class SaveUserController {

    @Autowired
    private UserServiceCaller userServiceCaller;

    @PostMapping
    public String saveUser(@RequestBody Map<String, Object> requestBody) {
        return userServiceCaller.saveUser(requestBody);
    }
}
