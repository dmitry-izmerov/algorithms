package ru.demi.algorithms.leetcode.graphs.disjoint_set;

public class QuickUnion extends AbstractDisjointSet implements DisjointSet {

    public QuickUnion(int length) {
        super(length);
    }

    public int findRoot(int vertex) {
        var root = vertex;
        while (root != roots[root]) {
            root = roots[root];
        }
        return root;
    }

    public void union(int vertexA, int vertexB) {
        var rootA = findRoot(vertexA);
        var rootB = findRoot(vertexB);
        if (rootA != rootB) {
            roots[rootB] = rootA;
        }
    }
}
