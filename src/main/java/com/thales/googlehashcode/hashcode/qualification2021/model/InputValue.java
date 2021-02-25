package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Builder
@Data
public class InputValue {

    public final GlobalConfig globalConfig;
    public final List<Street> allStreets;
    public final List<Car> cars;
    public final Set<Intersection> intersections;

    public InputValue(GlobalConfig globalConfig, List<Street> allStreets, List<Car> cars, Set<Intersection> intersections) {
        this.globalConfig = globalConfig;
        this.allStreets = allStreets;
        this.intersections = intersections;
        this.cars = cars;
    }
}
