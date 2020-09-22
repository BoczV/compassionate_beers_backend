package com.codecool.beerservice.controller;

import com.codecool.beerservice.component.RemoteURLReader;
import com.codecool.beerservice.model.DetailedBeer;
import com.codecool.beerservice.service.DetailedBeerServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/beer")
public class BeerController {

    private final String apiBasicEndpoint = "https://api.punkapi.com/v2/beers";

    @Autowired
    RemoteURLReader remoteURLReader;

    @Autowired
    DetailedBeerServiceCaller detailedBeerServiceCaller;

    @GetMapping("/all/{page}")
    public String returnBeers(@PathVariable("page") String page) throws IOException {
        return remoteURLReader.readFromUrl(apiBasicEndpoint + "?page=" + page);
    }

    @GetMapping("/random")
    public String returnRandomBeer() throws IOException {
        return remoteURLReader.readFromUrl(apiBasicEndpoint + "/random");
    }

    @GetMapping("/{id}")
    public DetailedBeer returnDetailedBeer(@PathVariable("id") String id){
        DetailedBeer detailedBeer = detailedBeerServiceCaller.getDetailedBeer(id);
        System.out.println(detailedBeer);
        return detailedBeer;
    }
}
