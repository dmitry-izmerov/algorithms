package ru.demi.algorithms.graphs.disjoint_sets;

public class QuickFind {
    private final int[] roots;

    public QuickFind(int length) {
        roots = new int[length];
        for (int i = 0; i < length; i++) {
            roots[i] = i;
        }
    }

    public int findRoot(int vertex) {
        return roots[vertex];
    }

    public void union(int vertexA, int vertexB) {
        int rootA = findRoot(vertexA);
        int rootB = findRoot(vertexB);
        for (int i = 0; i < roots.length; i++) {
            if (findRoot(i) == rootB) {
                roots[i] = rootA;
            }
        }
    }

    public boolean isConnected(int vertexA, int vertexB) {
        return findRoot(vertexA) == findRoot(vertexB);
    }
}
