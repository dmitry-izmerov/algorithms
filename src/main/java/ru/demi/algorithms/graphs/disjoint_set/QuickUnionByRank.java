package ru.demi.algorithms.graphs.disjoint_set;

import java.util.Arrays;

public class QuickUnionByRank extends QuickUnion {
    private final int[] ranks;

    public QuickUnionByRank(int length) {
        super(length);
        ranks = new int[length];
        Arrays.fill(ranks, 1);
    }

    @Override
    public void union(int vertexA, int vertexB) {
        int rootA = findRoot(vertexA);
        int rootB = findRoot(vertexB);
        if (rootA != rootB) {
            if (ranks[rootA] >= ranks[rootB]) {
                roots[rootB] = rootA;
                ranks[rootA] += ranks[rootB];
            } else {
                roots[rootA] = rootB;
            }
        }
    }
}
