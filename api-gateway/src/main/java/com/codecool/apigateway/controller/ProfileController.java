package com.codecool.apigateway.controller;

import com.codecool.apigateway.model.User;
import com.codecool.apigateway.security.JwtTokenServices;
import com.codecool.apigateway.service.BeerServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenServices jwtTokenServices;

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    BeerServiceCaller beerServiceCaller;

    public ProfileController(AuthenticationManager authenticationManager, JwtTokenServices jwtTokenServices) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenServices = jwtTokenServices;
    }

    @GetMapping("/{username}")
    public User getMe(@PathVariable String username){
        return beerServiceCaller.getUser(username);
    }
}
