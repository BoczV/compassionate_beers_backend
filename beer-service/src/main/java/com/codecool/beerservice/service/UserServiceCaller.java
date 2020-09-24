package com.codecool.beerservice.service;

import com.codecool.beerservice.model.DetailedBeer;
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


    public String saveUser(Object object) {
        return template.postForEntity(basicURL + "/save-user", object, String.class).getBody();
    }
}
