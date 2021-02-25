package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GlobalConfig {

    Integer duration;
    Integer intersectionNumber;
    Integer streetNumber;
    Integer carNumber;
    Integer scoringPoint;
}
