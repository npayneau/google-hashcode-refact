package com.thales.googlehashcode.hashcode.qualification2021.model;

import com.thales.googlehashcode.hashcode.qualification2021.oldmodel.Library;
import lombok.Data;

import java.util.List;

@Data
public class InputValue {

    public final int nbBooks;
    public final List<Library> libraries;
    public final int days;

    public InputValue(int nbBooks, List<Library> libraries, int days) {
        this.nbBooks = nbBooks;
        this.libraries = libraries;
        this.days = days;

    }

    @Override
    public String toString() {
        return "InputValue{" +
                "nbBooks=" + nbBooks +
                ", libraries=" + libraries.size() +
                ", days=" + days +
                '}';
    }
}
