package com.codecool.beerservice.service;

import com.codecool.beerservice.model.DetailedBeer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DetailedBeerServiceCaller {

    @Autowired
    private RestTemplate template;


    private final String basicURL = "http://detailedbeerservice/detailedbeerservice/";


    public DetailedBeer getDetailedBeer(String id){
        DetailedBeer detailedBeer = template.getForEntity(basicURL + id, DetailedBeer.class).getBody();
        System.out.println("this what received:" + detailedBeer);
        return detailedBeer;
    }

}
