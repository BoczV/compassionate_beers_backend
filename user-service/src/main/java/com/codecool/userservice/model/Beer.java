package com.codecool.userservice.model;

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
@Entity
public class Beer {

    @Id
    private Long id;

    private String image_url;

    @Column(nullable = false)
    private String name;

    private String first_brewed;

    private Float abv;

    private String username;
}
