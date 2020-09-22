package com.codecool.detailedbeerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hop {

    private String name;
    private Float amount;
    private String unit;
    private String add;
    private String attribute;
}
