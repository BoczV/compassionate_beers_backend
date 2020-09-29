package com.codecool.apigateway.service;

import com.codecool.apigateway.model.Beer;
import com.codecool.apigateway.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BeerServiceCaller {

    @Autowired
    private RestTemplate template;

    private final String basicUrl = "http://beerservice/";

    public String saveUser(User user) {
        return template.postForEntity(basicUrl + "/user/save", user, String.class).getBody();
    }

    public User getUser(String username){
        return template.getForEntity(basicUrl + "/user/get/" + username, User.class).getBody();
    }

    public String saveBeer(@RequestBody Map<String, Object> reqBody) {
        Beer beer = Beer.builder().abv(Float.valueOf(reqBody.get("alcohol").toString()))
                .id(Long.valueOf(reqBody.get("id").toString())).name((String) reqBody.get("name"))
                .first_brewed((String) reqBody.get("brewedDate")).image_url((String) reqBody.get("img"))
                .username((String)reqBody.get("username")).build();
        System.out.println("api gateway: controller, " + beer);
        return template.postForEntity(basicUrl + "favorites/save", beer, String.class).getBody();
    }

    public List<Beer> getBeers(String username){
        System.out.println(username);
        return template.getForEntity(basicUrl + "favorites/get-beers/" + username, List.class).getBody();
    }
}
