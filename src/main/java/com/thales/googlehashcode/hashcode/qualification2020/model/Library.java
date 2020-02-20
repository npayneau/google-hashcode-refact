package com.thales.googlehashcode.hashcode.qualification2020.model;

import lombok.Data;

import java.util.List;

@Data
public class Library {

    private final List<Book> books;
    private final int nbBooks;
    private final int signupProcess;
    private final int nbShipPerDay;

    public Library(List<Book> books, int nbBooks, int signupProcess, int nbShipPerDay) {
        this.books = books;
        this.nbBooks = nbBooks;
        this.signupProcess = signupProcess;
        this.nbShipPerDay = nbShipPerDay;
    }
}
