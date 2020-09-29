package com.codecool.userservice.controller;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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


    @PostMapping("/del/{id}")
    public String saveFavorite(@PathVariable String id){
        Long longId = Long.parseLong(id);

        try {
            beerRepository.deleteBeerById(longId);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Error: " + e);
        }

        return "OK";
    }

    @GetMapping("/get-beers/{username}")
    public List<Beer> getBeers(@PathVariable String username){
        System.out.println(username);
        return beerRepository.findByUsername(username);
    }
}
