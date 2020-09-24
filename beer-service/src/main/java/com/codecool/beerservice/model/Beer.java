package com.codecool.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beer {

    private Long id;

    private String img;

    private String name;

    private String brewed_Date;

    private Float alcohol_ratio;

    private String username;
}
