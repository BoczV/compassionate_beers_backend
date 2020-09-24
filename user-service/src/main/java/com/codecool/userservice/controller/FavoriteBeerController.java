package com.codecool.userservice.controller;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class FavoriteBeerController {

    @Autowired
    BeerRepository beerRepository;

    @PostMapping("/save")
    public void saveFavorite(@RequestBody Beer beer){
        System.out.println("user-service: controller, " + beer);
        beerRepository.save(beer);
    }

    @GetMapping("/get-beers/{username}")
    public List<Beer> getBeers(@PathVariable String username){
        return beerRepository.findByUsername(username);
    }
}
