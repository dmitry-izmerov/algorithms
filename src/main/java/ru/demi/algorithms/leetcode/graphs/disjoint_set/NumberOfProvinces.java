package ru.demi.algorithms.leetcode.graphs.disjoint_set;

import java.util.Arrays;

public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        DisjointSet set = new DisjointSet(isConnected);
        return set.getNumOfRoots();
    }
    
    static class DisjointSet {
        private final int[] roots;
        private final int[] ranks;
        private int rootsNum;

        public DisjointSet(int[][] isConnected) {
            int size = isConnected.length;
            rootsNum = size;
            roots = new int[size];
            for (int i = 0; i < size; ++i) {
                roots[i] = i;
            }
            ranks = new int[size];
            Arrays.fill(ranks, 1);
            for (int i = 0; i < size; ++i) {
                for (int j = i + 1; j < isConnected[0].length; ++j) {
                    if (isConnected[i][j] == 1) {
                        union(i, j);
                    }
                }
            }
        }

        public int findRoot(int vertex) {
            if (vertex == roots[vertex]) {
                return vertex;
            }
            roots[vertex] = findRoot(roots[vertex]);
            return roots[vertex];
        }

        public void union(int vertexA, int vertexB) {
            int rootA = findRoot(vertexA);
            int rootB = findRoot(vertexB);
            if (rootA == rootB) {
                return;
            }

            if (ranks[rootA] > ranks[rootB]) {
                roots[rootB] = rootA;
            } else if (ranks[rootA] < ranks[rootB]) {
                roots[rootA] = rootB;
            } else {
                roots[rootB] = rootA;
                ranks[rootA] +=1;
            }
            --rootsNum;
        }

        public int getNumOfRoots() {
            return rootsNum;
        }
    }
}

