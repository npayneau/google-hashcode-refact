package com.thales.googlehashcode.common.model.graph;

@FunctionalInterface
public interface IntegerBFSNextValueIterator {

    int nextInterationValue(int value, int iteration);
}
