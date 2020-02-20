package com.thales.googlehashcode.hashcode.qualification2020.model;

public class Book {

    public final int score;

    private Library rider;

    public Book(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "Book{" +
                "score=" + score +
                '}';
    }
}
