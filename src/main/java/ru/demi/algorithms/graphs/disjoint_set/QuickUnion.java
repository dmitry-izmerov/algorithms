package ru.demi.algorithms.graphs.disjoint_set;

public class QuickUnion implements DisjointSet {
    private final int[] roots;

    public QuickUnion(int length) {
        roots = new int[length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
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

    public boolean isConnected(int vertexA, int vertexB) {
        return findRoot(vertexA) == findRoot(vertexB);
    }
}
