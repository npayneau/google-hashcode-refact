package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Schedule {
    Street incomingStreet;
    Integer time;

    public Schedule(Street incomingStreet, Integer time) {
        this.incomingStreet = incomingStreet;
        this.time = time;
    }
}
