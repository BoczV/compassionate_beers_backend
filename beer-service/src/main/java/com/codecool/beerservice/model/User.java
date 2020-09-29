package com.codecool.beerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;

    private String userName;

    private String password;

    private String email;

    private Set<Integer> beerIds = new HashSet<>();

    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
