package com.codecool.beerservice.service;

import com.codecool.beerservice.model.Beer;
import com.codecool.beerservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class UserServiceCaller {

    @Autowired
    private RestTemplate template;

    private final String basicURL = "http://userservice/user";

    private final String basicURL2 = "http://userservice/favorites";


    public String saveUser(User user) {
        return template.postForEntity(basicURL + "/save", user, String.class).getBody();
    }

    public User getUser(String username){
        return template.getForEntity(basicURL + "/get/" + username, User.class).getBody();
    }

    public String saveBeer(Beer beer){
        return template.postForEntity(basicURL2 + "/save", beer, String.class).getBody();
    }

    public List<Beer> getBeers(String username){
        System.out.println(username);
        return template.getForEntity(basicURL2 + "/get-beers/" + username, List.class).getBody();
    }
}
