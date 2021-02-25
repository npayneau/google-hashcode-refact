package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class StreetState {

    Street current;
    LinkedList<Car> cars;

    public StreetState(Street current, LinkedList<Car> cars) {
        this.current = current;
        this.cars = cars;
    }
}
