package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Builder
@Data
public class Intersection {

    int id;
    List<Schedule> incomingStreets;

    public Intersection(int id, List<Schedule> incomingStreets) {
        this.id = id;
        this.incomingStreets = incomingStreets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
