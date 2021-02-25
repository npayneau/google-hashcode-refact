package com.thales.googlehashcode.hashcode.qualification2021.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2021.model.InputValue;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {

        //create output
      /*  List<String> out = new ArrayList<>();
        out.add(String.valueOf(libraryOut.size()));
        for (Library library : libraryOut) {
            out.add(library.getId() + " " + library.getOutBooks().size());
            out.add(library.getOutBooksString().substring(0, library.getOutBooksString().length() - 1));
        }*/
        //return new HashCodeSolution(out, 50);
        return null;
    }
}
