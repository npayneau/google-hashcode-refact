package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Data;

@Data
public class Book {

    private final int id;
    public final int score;

    private Library rider;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Book{" +
                "score=" + score +
                '}';
    }
}
