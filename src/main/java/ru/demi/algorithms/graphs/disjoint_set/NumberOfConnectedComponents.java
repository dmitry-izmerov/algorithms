package ru.demi.algorithms.graphs.disjoint_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        DisjointSet set = new DisjointSet(n);
        set.build(edges);
        return set.getNumOfRoots();
    }

    static class DisjointSet {
        private final int[] roots;
        private final int[] ranks;

        DisjointSet(int n) {
            roots = new int[n];
            for (int i = 0; i < n; ++i) {
                roots[i] = i;
            }
            ranks = new int[n];
            Arrays.fill(ranks, 1);
        }

        void build(int[][] edges) {
            for (int[] edge: edges) {
                int vertA = edge[0];
                int vertB = edge[1];
                union(vertA, vertB);
            }
        }

        private void union(int vertA, int vertB) {
            int rootA = findRoot(vertA);
            int rootB = findRoot(vertB);

            if (ranks[rootA] >= ranks[rootB]) {
                roots[rootB] = rootA;
                ranks[rootA] += ranks[rootB];
            } else {
                roots[rootA] = rootB;
                ranks[rootB] += ranks[rootA];
            }
        }

        private int findRoot(int vertex) {
            if (roots[vertex] == vertex) {
                return vertex;
            }
            roots[vertex] = findRoot(roots[vertex]);
            return roots[vertex];
        }

        int getNumOfRoots() {
            Set<Integer> uniqueRoots = new HashSet<>();
            for (int i = 0; i < roots.length; ++i) {
                int root = findRoot(i);
                uniqueRoots.add(root);
            }
            return uniqueRoots.size();
        }
    }
}
