package com.codecool.detailedbeerservice.controller;

import com.codecool.detailedbeerservice.model.Hop;
import com.codecool.detailedbeerservice.model.Malt;
import com.google.gson.*;
import com.codecool.detailedbeerservice.component.RemoteURLReader;
import com.codecool.detailedbeerservice.model.DetailedBeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/detailedbeerservice")
public class DetailedBeerController {

    private final String basicAPIEndpoint = "https://api.punkapi.com/v2/beers/";

    @Autowired
    RemoteURLReader remoteURLReader;

    Gson googleJson = new Gson();

    @GetMapping("/{beer_id}")
    public DetailedBeer returnDetailedBeer(@PathVariable("beer_id") String beer_id) throws IOException {
        String beer = remoteURLReader.readFromUrl(basicAPIEndpoint + beer_id);
        String deListBeer = beer.substring(1, beer.length()-1);
        List<Hop> hops = new ArrayList<>();
        List<Malt> malts = new ArrayList<>();

        JsonObject beerJson = new JsonParser()
                .parse(deListBeer)
                .getAsJsonObject();

        for (JsonElement jsonHop :beerJson.get("ingredients").getAsJsonObject().get("hops").getAsJsonArray()) {
            hops.add(Hop.builder()
                    .name(jsonHop.getAsJsonObject().get("name").getAsString())
                    .add(jsonHop.getAsJsonObject().get("add").getAsString())
                    .attribute(jsonHop.getAsJsonObject().get("attribute").getAsString())
                    .amount(jsonHop.getAsJsonObject().get("amount").getAsJsonObject().get("value").getAsFloat())
                    .unit(jsonHop.getAsJsonObject().get("amount").getAsJsonObject().get("unit").getAsString())
                    .build());
        }

        for (JsonElement jsonMalt :beerJson.get("ingredients").getAsJsonObject().get("malt").getAsJsonArray()) {
            malts.add(Malt.builder()
                    .amount(jsonMalt.getAsJsonObject().get("amount").getAsJsonObject().get("value").getAsFloat())
                    .unit(jsonMalt.getAsJsonObject().get("amount").getAsJsonObject().get("unit").getAsString())
                    .name(jsonMalt.getAsJsonObject().get("name").getAsString())
                    .build());
        }

        DetailedBeer detailedBeer = DetailedBeer.builder()
                .id(beerJson.get("id").getAsInt())
                .alcohol_ratio(beerJson.get("abv").getAsFloat())
                .first_brewed(beerJson.get("first_brewed").getAsString())
                .foodPairing(googleJson.fromJson(beerJson.get("food_pairing"), List.class))
                .img_url(beerJson.get("image_url").getAsString())
                .name(beerJson.get("name").getAsString())
                .tagline(beerJson.get("tagline").getAsString())
                .yeast(beerJson.get("ingredients").getAsJsonObject().get("yeast").getAsString())
                .description(beerJson.get("description").getAsString())
                .hops(hops)
                .malts(malts)
                .build();

        return detailedBeer;
    }
}
