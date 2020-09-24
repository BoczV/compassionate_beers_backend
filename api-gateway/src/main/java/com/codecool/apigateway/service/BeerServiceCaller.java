package com.codecool.apigateway.service;

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

    private final String basicUrl = "http://beerservice/beer";

    public String saveUser(Object object) {
        return template.postForEntity(basicUrl + "/save-user", object, String.class).getBody();
    }
}
