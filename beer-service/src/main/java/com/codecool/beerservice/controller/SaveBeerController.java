package com.codecool.beerservice.controller;

import com.codecool.beerservice.model.Beer;
import com.codecool.beerservice.model.User;
import com.codecool.beerservice.service.UserServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class SaveBeerController {
    @Autowired
    private UserServiceCaller userServiceCaller;

    @PostMapping("/save")
    public String saveBeer(@RequestBody Beer beer) {
        return userServiceCaller.saveBeer(beer);
    }

    @GetMapping("/get-beers/{username}")
    public List<Beer> getBeers(@PathVariable String username){
        System.out.println(username);
        return userServiceCaller.getBeers(username);
    }
}
