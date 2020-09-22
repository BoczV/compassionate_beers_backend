package com.codecool.detailedbeerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedBeer {

    private Integer id;
    private String name;
    private String first_brewed;
    private Float alcohol_ratio;
    private String img_url;
    private String tagline;
    private String yeast;
    private List<String> foodPairing;
    private List<Hop> hops;
    private List<Malt> malts;

}
