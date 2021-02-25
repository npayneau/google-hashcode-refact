package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class InputValue {

    public final GlobalConfig globalConfig;
    public final List<Street> allStreets;
    public final List<Car> cars;

    public InputValue(GlobalConfig globalConfig, List<Street> allStreets, List<Car> cars) {
        this.globalConfig = globalConfig;
        this.allStreets = allStreets;
        this.cars = cars;
    }
}
