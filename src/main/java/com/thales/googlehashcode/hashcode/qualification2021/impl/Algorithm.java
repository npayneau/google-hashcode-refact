package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2021.model.Car;
import com.thales.googlehashcode.hashcode.qualification2021.model.InputValue;
import com.thales.googlehashcode.hashcode.qualification2021.model.Intersection;
import com.thales.googlehashcode.hashcode.qualification2021.model.Street;

import java.util.*;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {
        List<Intersection> intersections = new ArrayList<>();

        Set<Street> streetsLimited = new HashSet<>();
        for (Car car : input.getCars()) {
            car.getStreetsToVisit().removeFirst();
            car.getStreetsToVisit().removeLast();
            streetsLimited.addAll(car.getStreetsToVisit());
        }

        /* Algo 1
        for (Street street : input.allStreets) {*/
        for (Street street : streetsLimited) {
            Optional<Intersection> intersection = intersections.stream().filter(inter -> inter.getId() == street.getEndingPoint()).findFirst();
            if (intersection.isPresent()) {
                intersection.get().getIncomingStreets().put(street, 2);
            } else {
                HashMap<Street, Integer> streets = new HashMap<>();
                streets.put(street, 1);
                intersections.add(Intersection.builder().id(street.getEndingPoint()).incomingStreets(streets).build());
            }
        }
        //create output
        List<String> out = new ArrayList<>();
        out.add(String.valueOf(intersections.size()));
        for (Intersection intersection : intersections) {
            out.add(String.valueOf(intersection.getId()));
            out.add(String.valueOf(intersection.getIncomingStreets().size()));
            intersection.getIncomingStreets().forEach((street, time) -> out.add(street.getName() + " " + time));
        }
        return new HashCodeSolution(out, 50);
    }
}
