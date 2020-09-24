package com.codecool.apigateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    private Long id;

    private String image_url;

    private String name;

    private String first_brewed;

    private Float abv;

    private String username;
}
