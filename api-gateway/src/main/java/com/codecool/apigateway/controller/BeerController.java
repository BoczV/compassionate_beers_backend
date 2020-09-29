package com.codecool.apigateway.controller;

import com.codecool.apigateway.model.Beer;
import com.codecool.apigateway.service.BeerServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class BeerController {
    @Autowired
    BeerServiceCaller beerServiceCaller;

    @PostMapping("/save")
    public String saveBeer(@RequestBody Map<String, Object> reqBody){
        System.out.println(reqBody);
        return beerServiceCaller.saveBeer(reqBody);
    }

    @GetMapping("/get-beers/{username}")
    public List<Beer> getBeers(@PathVariable String username){
        System.out.println(username);
        return beerServiceCaller.getBeers(username);
    }
}
