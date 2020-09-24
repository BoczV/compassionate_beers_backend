package com.codecool.userservice.controller.favorite_beers;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.model.User;
import com.codecool.userservice.repository.BeerRepository;
import com.codecool.userservice.repository.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
@CrossOrigin("*")
public class SaveFavoriteBeerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BeerRepository beerRepository;

    @PostMapping("/save")
    public String saveFavoriteBeer(@RequestBody String beer, String username) throws JSONException {
        User user = userRepository.findByUserName(username).get();
        JSONObject receivedBeer = new JSONObject(beer);
        Beer actualBeer = Beer.builder()
                .alcohol_ratio((Float) receivedBeer.get("alcohol_ratio"))
                .brewed_Date(receivedBeer.getString("brewed_date"))
                .img(receivedBeer.getString("img"))
                .id(receivedBeer.getLong("id"))
                .name(receivedBeer.getString("name"))
                .user(user)
                .build();

        beerRepository.save(actualBeer);
        return "Ok.";
    }
}
