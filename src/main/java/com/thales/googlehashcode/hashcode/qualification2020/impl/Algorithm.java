package com.thales.googlehashcode.hashcode.qualification2020.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2020.model.Book;
import com.thales.googlehashcode.hashcode.qualification2020.model.InputValue;
import com.thales.googlehashcode.hashcode.qualification2020.model.Library;

import java.util.*;
import java.util.stream.Collectors;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    Set<Book> booksProceed = new HashSet<>();

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {
        List<Library> sortedLibrary = input.getLibraries().stream().sorted(Comparator.comparing(Library::getRatio)).collect(Collectors.toList());
        int libraryProceed = 0;
        List<Library> libraryProceedList = new ArrayList<>();
        List<Library> libraryOut = new ArrayList<>();
        Library librarySignup = null;
        int signupProcess = 0;
        for (int i = 0; i < input.getDays(); i++) {
            if (signupProcess == 0) {
                if (librarySignup != null) {
                    libraryProceedList.add(librarySignup);
                    libraryOut.add(librarySignup);
                    libraryProceed++;
                }
                librarySignup = sortedLibrary.get(libraryProceed);
                librarySignup.sortedBooks();
                signupProcess = librarySignup.getSignupProcess() - 1;
            } else {
                signupProcess--;
            }
            //traitement des librairie en cours
            Library removeLibrary = null;
            for (Library library : libraryProceedList) {
                if (library.proceedBooks()) {
                    removeLibrary = library;
                }
            }
            if (removeLibrary != null) {
                libraryProceedList.remove(removeLibrary);
            }
        }

        //create output
        List<String> out = new ArrayList<>();
        out.add(String.valueOf(libraryOut.size()));
        for (Library library : libraryOut) {
            out.add(library.getId() + " " + library.getOutBooks().size());
            out.add(library.getOutBooksString().substring(0, library.getOutBooksString().length() - 1));
        }
        return new HashCodeSolution(out, 50);
    }
}
