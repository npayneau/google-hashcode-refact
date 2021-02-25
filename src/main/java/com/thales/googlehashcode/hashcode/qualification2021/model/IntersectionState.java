package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Data;

import java.util.List;

@Data
public class IntersectionState {

    int indexIntersection;
    List<StreetState> streetStates;
}
