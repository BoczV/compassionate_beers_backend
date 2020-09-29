package com.codecool.beerservice.controller;

import com.codecool.beerservice.model.User;
import com.codecool.beerservice.service.UserServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class SaveUserController {

    @Autowired
    private UserServiceCaller userServiceCaller;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        return userServiceCaller.saveUser(user);
    }

    @GetMapping("/get/{username}")
    public User getUser(@PathVariable String username){
        return userServiceCaller.getUser(username);
    }
}
