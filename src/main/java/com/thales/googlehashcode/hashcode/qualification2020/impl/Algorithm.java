package com.thales.googlehashcode.hashcode.qualification2020.impl;

import com.thales.googlehashcode.hashcode.common.HashCodeAlgorithm;
import com.thales.googlehashcode.hashcode.common.HashCodeLogger;
import com.thales.googlehashcode.hashcode.common.HashCodeSolution;
import com.thales.googlehashcode.hashcode.qualification2020.model.InputValue;

import java.util.ArrayList;

public class Algorithm implements HashCodeAlgorithm<InputValue> {

    @Override
    public HashCodeSolution run(InputValue input, HashCodeLogger logger) {
        System.out.println(input.toString());
        return new HashCodeSolution(new ArrayList<>(), 50);
    }
}
