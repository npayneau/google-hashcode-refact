package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2021.model.InputValue;
import com.thales.googlehashcode.hashcode.qualification2021.model.Intersection;

import java.util.ArrayList;
import java.util.List;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {
        List<Intersection> intersections = new ArrayList<>();
        //create output
        List<String> out = new ArrayList<>();
        out.add(String.valueOf(intersections.size()));
        for (Intersection intersection : intersections) {
            out.add(String.valueOf(intersection.getId()));
            out.add(String.valueOf(intersection.getIncomingStreets().size()));
            intersection.getIncomingStreets().forEach((street, time) -> out.add(street + " " + time));
        }
        return new HashCodeSolution(out, 50);
    }
}
