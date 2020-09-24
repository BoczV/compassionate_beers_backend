package com.codecool.userservice.controller.favorite_beers;

import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class AllFavoriteBeerController {

    @Autowired
    private UserRepository userRepository;


}
