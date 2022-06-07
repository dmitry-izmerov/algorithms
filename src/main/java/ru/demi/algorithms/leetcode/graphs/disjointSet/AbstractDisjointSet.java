package ru.demi.algorithms.leetcode.graphs.disjointSet;

public abstract class AbstractDisjointSet implements DisjointSet {
    protected final int[] roots;

    public AbstractDisjointSet(int length) {
        roots = new int[length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
    }

    public boolean isConnected(int vertexA, int vertexB) {
        return findRoot(vertexA) == findRoot(vertexB);
    }
}
