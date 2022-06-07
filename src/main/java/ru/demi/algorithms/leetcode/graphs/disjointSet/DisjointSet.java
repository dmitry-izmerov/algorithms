package ru.demi.algorithms.leetcode.graphs.disjointSet;

public interface DisjointSet {

    int findRoot(int vertex);

    void union(int vertexA, int vertexB);

    boolean isConnected(int vertexA, int vertexB);
}
