package com.codecool.apigateway.component;

import com.codecool.apigateway.model.User;
import com.codecool.apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class FindUserByCookie {

    @Autowired
    UserRepository userRepository;

    public User findUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) authentication.getPrincipal();
        return userRepository.findByUserName(userName).get();
    }
}
