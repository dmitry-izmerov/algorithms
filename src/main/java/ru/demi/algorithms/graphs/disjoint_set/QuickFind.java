package ru.demi.algorithms.graphs.disjoint_set;

public class QuickFind implements DisjointSet {
    private final int[] roots;

    public QuickFind(int length) {
        roots = new int[length];
        for (int i = 0; i < length; i++) {
            roots[i] = i;
        }
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

    @Override
    public boolean isConnected(int vertexA, int vertexB) {
        return findRoot(vertexA) == findRoot(vertexB);
    }
}
