package com.codecool.beerservice.service;

import com.codecool.beerservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceCaller {

    @Autowired
    private RestTemplate template;

    private final String basicURL = "http://userservice/user";


    public String saveUser(User user) {
        return template.postForEntity(basicURL + "/save", user, String.class).getBody();
    }

    public User getUser(String username){
        return template.getForEntity(basicURL + "/get/" + username, User.class).getBody();
    }
}
