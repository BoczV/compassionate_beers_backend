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


    @GetMapping("/search/{page}/{beer-name}/{food-name}/{alcohol}/{brewed-before}/{brewed-after}")
    public String returnSearchResults(@PathVariable("beer-name") String beerName, @PathVariable("food-name") String foodName,
                                      @PathVariable("alcohol") String alcohol, @PathVariable("brewed-before") String brewedBefore,
                                      @PathVariable("brewed-after") String brewedAfter, @PathVariable("page") String page) throws IOException {
        String endpoint = endPointBuilder(beerName, foodName, brewedAfter, brewedBefore, alcohol, apiBasicEndpoint);
        return remoteURLReader.readFromUrl(endpoint);
    }


    private String endPointBuilder(String beerName, String foodName, String brewedAfter, String brewedBefore, String alcohol, String endpoint){
        endpoint += "?abv_gt=" + alcohol;
        if(!beerName.equals(" ")){
            endpoint += "&beer_name=" + beerName;
        }
        if(!foodName.equals(" ")){
            endpoint += "&food=" + foodName;
        }
        endpoint += "&brewed_after=" + brewedAfter + "&brewed_before=" + brewedBefore;
        return endpoint;
    }
}
