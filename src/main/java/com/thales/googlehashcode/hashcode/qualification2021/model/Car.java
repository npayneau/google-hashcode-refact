package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedList;

@Builder
@Data
public class Car {

    Integer streetCount;
    LinkedList<Street> streetsToVisit;
}
