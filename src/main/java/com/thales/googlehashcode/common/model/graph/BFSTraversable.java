package com.thales.googlehashcode.common.model.graph;

@FunctionalInterface
public interface BFSTraversable<N> {

    boolean canBeVisited(N node);
}
