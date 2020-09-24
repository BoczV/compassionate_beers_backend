package com.codecool.userservice.component;

import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUserByCookie {

    @Autowired
    private UserRepository userRepository;

    public User findUser() {

    }
}
