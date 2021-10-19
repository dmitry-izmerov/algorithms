package ru.demi.algorithms.leetcode.graphs.disjoint_set;

public class QuickUnionWithPathCompression extends QuickUnion {
    public QuickUnionWithPathCompression(int length) {
        super(length);
    }

    @Override
    public int findRoot(int vertex) {
        if (vertex == roots[vertex]) {
            return vertex;
        }
        roots[vertex] = findRoot(roots[vertex]);
        return roots[vertex];
    }
}
