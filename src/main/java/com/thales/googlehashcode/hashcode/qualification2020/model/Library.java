package com.thales.googlehashcode.hashcode.qualification2020.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

@Data
public class Library {

    private final List<Book> books;
    private Stack<Book> sortedBooks;
    private List<Book> outBooks;
    private String outBooksString;
    private final int nbBooks;
    private final int signupProcess;
    private final int nbShipPerDay;
    private int bookProceedIndex;
    private boolean isProceed;
    private int id;

    public Library(int id, List<Book> books, int nbBooks, int signupProcess, int nbShipPerDay) {
        this.id = id;
        this.books = books;
        this.nbBooks = nbBooks;
        this.signupProcess = signupProcess;
        this.nbShipPerDay = nbShipPerDay;
        outBooks = new ArrayList<>();
        bookProceedIndex = 0;
    }

    public Double getRatio() {
        return (nbShipPerDay * getMedian()) / signupProcess;
    }

    private Double getMedian() {
        return books.stream().mapToInt(Book::getScore).average().orElse(0);
    }

    public void sortedBooks() {
        this.getBooks().stream().sorted(Comparator.comparing(Book::getScore)).collect(Collectors.toList());
        sortedBooks.size();
    }

    public boolean proceedBooks() {
        for (int i = 0; i < nbShipPerDay; i++) {
            Book b = this.sortedBooks.get(bookProceedIndex);
            outBooks.add(b);
            createOutBooksString(b);
            bookProceedIndex++;
            if (bookProceedIndex == nbBooks) {
                //Library is fully proceed
                return true;
            }
        }
        //IsProceed
        return false;
    }

    private void createOutBooksString(Book b) {
        outBooksString += b.getId() + " ";
    }

}
