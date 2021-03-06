package ru.demi.algorithms.leetcode.graphs.disjointSet;

public class QuickFind extends AbstractDisjointSet implements DisjointSet {
    public QuickFind(int length) {
        super(length);
    }

    @Override
    public int findRoot(int vertex) {
        return roots[vertex];
    }

    @Override
    public void union(int vertexA, int vertexB) {
        int rootA = findRoot(vertexA);
        int rootB = findRoot(vertexB);
        for (int i = 0; i < roots.length; i++) {
            if (findRoot(i) == rootB) {
                roots[i] = rootA;
            }
        }
    }
}
