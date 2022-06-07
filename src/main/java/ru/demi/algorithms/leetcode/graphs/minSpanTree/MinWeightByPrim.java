package ru.demi.algorithms.leetcode.graphs.minSpanTree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinWeightByPrim {

    public static int minWeightConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] firstCoordinate = points[0];
        int size = points.length;
        for (int i = 0; i < size; ++i) {
            queue.add(new Edge(0, i, calcDistance(firstCoordinate, points[i])));
        }

        boolean[] visited = new boolean[size];
        visited[0] = true;

        int result = 0;
        int count = 0;
        while (!queue.isEmpty() && count < size) {
            Edge edge = queue.remove();
            if (!visited[edge.point2]) {
                result += edge.weight;
                int edgePoint = edge.point2;
                visited[edgePoint] = true;

                int[] coord1 = points[edgePoint];
                for (int i = 0; i < size; ++i) {
                    if (!visited[i]) {
                        int[] coord2 = points[i];
                        queue.add(new Edge(edgePoint, i, calcDistance(coord1, coord2)));
                    }
                }
                ++count;
            }
        }

        return result;
    }

    private static int calcDistance(int[] coordinate1, int[] coordinate2) {
        return Math.abs(coordinate1[0] - coordinate2[0]) + Math.abs(coordinate1[1] - coordinate2[1]);
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
}
