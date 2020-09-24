package com.codecool.beerservice.controller;

import com.codecool.beerservice.service.UserServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/save-user")
@CrossOrigin("*")
public class SaveUserController {

    @Autowired
    private UserServiceCaller userServiceCaller;

    @PostMapping
    public String saveUser(@RequestBody Map<String, Object> requestBody) {
        return userServiceCaller.saveUser(requestBody);
    }
}
