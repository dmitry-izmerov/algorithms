package ru.demi.algorithms.leetcode.graphs.disjointSet;

import java.util.Arrays;
import java.util.Comparator;

class AllFriendsEarliest {

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        FriendsConnection fc = new FriendsConnection(n, logs);
        return fc.getEarliestAcqForAll();
    }
    
    static class FriendsConnection {
        private final int[] parents;
        private final int[] ranks;
        private int earliestAcq = Integer.MAX_VALUE;
        
        FriendsConnection(int size, int[][] logs) {
            parents = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; ++i) {
                parents[i] = i;
                ranks[i] = 1;
            }
            build(logs);
        }

        int getEarliestAcqForAll() {
            return earliestAcq;
        }
        
        private void build(int[][] logs) {
            for (int[] ar : logs) {
                int timestamp = ar[0];
                union(ar[1], ar[2]);
                if (isAllConnected() && timestamp < earliestAcq) {
                    earliestAcq = timestamp;
                    return;
                }
            }
            earliestAcq = -1;
        }
        
        private void union(int vertA, int vertB) {
            int rootA = findRoot(vertA);
            int rootB = findRoot(vertB);
            if (rootA == rootB) {
                return;
            }
            if (ranks[rootA] >= ranks[rootB]) {
                parents[rootB] = rootA;
                ranks[rootA] += ranks[rootB];
            } else {
                parents[rootA] = rootB;
                ranks[rootB] += ranks[rootA];
            }
        }
        
        private int findRoot(int vertex) {
            int root = vertex;
            while (parents[root] != root) {
                root = parents[root];
            }
            
            int prev = 0;
            int next = vertex;
            while (next != root) {
                prev = next;
                next = parents[next];
                parents[prev] = root;
            }
            return root;
        }

        private boolean isAllConnected() {
            int root = findRoot(0);
            for (int i = 1; i < parents.length; ++i) {
                if (root != findRoot(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
