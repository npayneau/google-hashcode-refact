package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class State {

    List<IntersectionState> intersectionStates;

    public State() {
        this.intersectionStates = new ArrayList<>();
    }
}
