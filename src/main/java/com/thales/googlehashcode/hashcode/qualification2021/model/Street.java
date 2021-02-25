package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Street {

    Integer startingPoint;
    Integer endingPoint;
    Integer duration;
    String name;

}
