package com.codecool.apigateway.service;

import com.codecool.apigateway.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class BeerServiceCaller {

    @Autowired
    private RestTemplate template;

    private final String basicUrl = "http://beerservice/beerservice";

    public String saveUser(User user) {
        return template.postForEntity(basicUrl + "/user/save", user, String.class).getBody();
    }

    public User getUser(String username){
        return template.getForEntity(basicUrl + "/user/get/" + username, User.class).getBody();
    }
}
