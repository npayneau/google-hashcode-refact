package com.thales.googlehashcode.hashcode.qualification2021.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Library {

    private final List<Book> books;
    private List<Book> sortedBooks;
    private List<Book> outBooks;
    private String outBooksString;
    private final int nbBooks;
    private final int signupProcess;
    private final int nbShipPerDay;
    private int bookProceedIndex;
    private boolean isProceed;
    private Double ratio;
    private int id;

    public Library(int id, List<Book> books, int nbBooks, int signupProcess, int nbShipPerDay) {
        this.id = id;
        this.books = books;
        this.nbBooks = nbBooks;
        this.signupProcess = signupProcess;
        this.nbShipPerDay = nbShipPerDay;
        outBooks = new ArrayList<>();
        bookProceedIndex = 0;
        outBooksString = "";
    }

    public Double getRatio() {
        ratio = (nbShipPerDay * getMedian()) / signupProcess;
        return ratio;
    }

    private Double getMedian() {
        return books.stream().mapToInt(Book::getScore).average().orElse(0);
    }

    public void sortedBooks() {
        sortedBooks = this.getBooks().stream().sorted(Comparator.comparing(Book::getScore).reversed()).collect(Collectors.toList());
    }

    public boolean proceedBooks() {
        for (int i = 0; i < nbShipPerDay; i++) {
            if (bookProceedIndex == nbBooks) {
                //Library is fully proceed
                return true;
            }
            Book b = this.sortedBooks.get(bookProceedIndex);
            outBooks.add(b);
            createOutBooksString(b);
            bookProceedIndex++;
        }
        //IsProceed
        return false;
    }

    private void createOutBooksString(Book b) {
        outBooksString += b.getId() + " ";
    }

}
