package com.codecool.detailedbeerservice.controller;

import com.codecool.detailedbeerservice.model.Hop;
import com.codecool.detailedbeerservice.model.Malt;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.codecool.detailedbeerservice.component.RemoteURLReader;
import com.codecool.detailedbeerservice.model.DetailedBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/detailedbeerservice")
public class DetailedBeerController {

    private final String basicAPIEndpoint = "https://api.punkapi.com/v2/beers/";

    @Autowired
    RemoteURLReader remoteURLReader;

    @GetMapping("/{beer_id}")
    public DetailedBeer returnDetailedBeer(@PathVariable("beer_id") String beer_id) throws IOException {
        String beer = remoteURLReader.readFromUrl(basicAPIEndpoint + beer_id);
        /*return beer;*/
        JsonObject beerJson = new JsonParser()
                .parse(beer)
                .getAsJsonObject();
        DetailedBeer detailedBeer = DetailedBeer.builder()
                .id(beerJson.get("id").getAsInt())
                .alcohol_ratio(beerJson.get("abv").getAsFloat())
                .first_brewed(beerJson.get("first_brewed").getAsString())
                .foodPairing(Collections.singletonList(beerJson.get("food_pairing").getAsString()))
                .img_url(beerJson.get("image_url").getAsString())
                .name(beerJson.get("name").getAsString())
                .tagline(beerJson.get("tagline").getAsString())
                .yeast(beerJson.get("ingredients").getAsJsonObject().get("yeast").getAsString()).build();
        List<Hop> hops = (List<Hop>) beerJson.get("ingredients").getAsJsonObject().get("hops");
        List<Malt> malts = (List<Malt>) beerJson.get("ingredients").getAsJsonObject().get("malts");
        detailedBeer.setHops(hops);
        detailedBeer.setMalts(malts);
        return detailedBeer;
    }
}
