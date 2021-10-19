package ru.demi.algorithms.leetcode.graphs.min_span_tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinWeightByKruskal {

    public static int minWeightConnectPoints(int[][] points) {
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int size = points.length;
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size; ++j) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                queue.add(new Edge(i, j, weight));
            }
        }

        UnionFind unionFind = new UnionFind(size);
        int count = 0;
        int result = 0;
        while (!queue.isEmpty() && count < size) {
            Edge edge = queue.remove();
            if (!unionFind.isConnected(edge.point1, edge.point2)) {
                unionFind.union(edge.point1, edge.point2);
                result += edge.weight;
                ++count;
            }
        }
        return result;
    }

    static class Edge {
        final int point1;
        final int point2;
        final int weight;

        Edge(int point1, int point2, int weight) {
            this.point1 = point1;
            this.point2 = point2;
            this.weight = weight;
        }
    }

    static class UnionFind {
        final int[] parents;
        final int[] ranks;

        UnionFind(int size) {
            parents = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; ++i) {
                parents[i] = i;
            }
            Arrays.fill(ranks, 1);
        }

        int findRoot(int vertex) {
            if (parents[vertex] == vertex) {
                return vertex;
            }
            parents[vertex] = findRoot(parents[vertex]);
            return parents[vertex];
        }

        void union(int vertexA, int vertexB) {
            int rootA = findRoot(vertexA);
            int rootB = findRoot(vertexB);

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

        boolean isConnected(int vertexA, int vertexB) {
            return findRoot(vertexA) == findRoot(vertexB);
        }
    }
}
