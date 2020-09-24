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

    private final String basicURL = "http://userservice/userservice";


    public String saveUser(User user) {
        return template.postForEntity(basicURL + "/user/save", user, String.class).getBody();
    }

    public User getUser(String username){
        return template.getForEntity(basicURL + "/user/get/" + username, User.class).getBody();
    }
}
