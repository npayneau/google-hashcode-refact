package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class Intersection {

    private int id;
    private Map<Street, Integer> incomingStreets;
}
