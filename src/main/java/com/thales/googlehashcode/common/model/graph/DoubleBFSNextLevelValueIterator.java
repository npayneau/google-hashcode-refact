package com.thales.googlehashcode.common.model.graph;

@FunctionalInterface
public interface DoubleBFSNextLevelValueIterator {

    double nextInterationValue(double value, int iteration);
}
