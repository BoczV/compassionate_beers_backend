package com.codecool.userservice.controller.favorite_beers;

import com.codecool.userservice.component.FindUserByCookie;
import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class AllFavoriteBeerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FindUserByCookie findUserByCookie;

    @GetMapping
    public String getAllFavoriteBeers() {
        User user = findUserByCookie.findUser();

    }

    public String getBeersById(Set<String> ids) {
        List<String> result = new ArrayList<>();
        for (String id : ids) {
            result.add();
        }
    }
}
