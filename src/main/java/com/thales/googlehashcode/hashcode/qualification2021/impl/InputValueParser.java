package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeInputValueParser;
import com.thales.googlehashcode.hashcode.qualification2021.model.Book;
import com.thales.googlehashcode.hashcode.qualification2021.model.InputValue;
import com.thales.googlehashcode.hashcode.qualification2021.model.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputValueParser implements HashCodeInputValueParser<InputValue> {

    @Override
    public InputValue parse(Scanner scanner) {
        final String[] firstLine = scanner.nextLine().split(" ");
        final int nbBooks = Integer.parseInt(firstLine[0]);
        final int nbLibraries = Integer.parseInt(firstLine[1]);
        final int nbDay = Integer.parseInt(firstLine[2]);

        final String[] booksScore = scanner.nextLine().split(" ");

        final List<Library> libraries = new ArrayList<>(nbLibraries);

        for (int i = 0; i < nbLibraries; i++) {
            final String[] rideLine = scanner.nextLine().split(" ");
            final int nbBooksLib = Integer.parseInt(rideLine[0]);
            final int signupProcess = Integer.parseInt(rideLine[1]);
            final int nbShipPerDay = Integer.parseInt(rideLine[2]);
            final String[] booksId = scanner.nextLine().split(" ");
            List<Book> books = new ArrayList<>();
            for (int j = 0; j < nbBooksLib; j++) {
                books.add(new Book(Integer.parseInt(booksId[j]), Integer.parseInt(booksScore[Integer.parseInt(booksId[j])])));
            }
            libraries.add(new Library(i, books, nbBooksLib, signupProcess, nbShipPerDay));
        }

        return new InputValue(nbBooks, libraries, nbDay);
    }
}
