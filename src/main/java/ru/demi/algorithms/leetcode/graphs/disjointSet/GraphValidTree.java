package ru.demi.algorithms.leetcode.graphs.disjointSet;

public class GraphValidTree {

    public static boolean check(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        DisjointSet set = new DisjointSet(n);
        return set.build(edges);
    }

    static class DisjointSet {
        private final int[] roots;
        private final int[] ranks;

        DisjointSet(int n) {
            roots = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; ++i) {
                roots[i] = i;
                ranks[i] = 1;
            }
        }

        boolean build(int[][] edges) {
            for (int[] edge : edges) {
                int A = edge[0];
                int B = edge[1];
                if (!union(A, B)) {
                    return false;
                }
            }
            return true;
        }

        private boolean union(int vertA, int vertB) {
            int rootA = findRoot(vertA);
            int rootB = findRoot(vertB);
            if (rootA == rootB) {
                return false;
            }

            if (ranks[rootB] > ranks[rootA]) {
                roots[rootA] = rootB;
                ranks[rootB] += ranks[rootA];
            } else {
                roots[rootB] = rootA;
                ranks[rootA] += ranks[rootB];
            }
            return true;
        }

        public int findRoot(int vertex) {
            int root = vertex;
            while (roots[root] != root) {
                root = roots[root];
            }
            while (vertex != root) {
                int oldRoot = roots[vertex];
                roots[vertex] = root;
                vertex = oldRoot;
            }
            return root;
        }
    }
}
