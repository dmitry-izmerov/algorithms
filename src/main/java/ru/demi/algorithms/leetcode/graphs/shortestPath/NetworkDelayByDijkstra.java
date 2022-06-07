package ru.demi.algorithms.leetcode.graphs.shortestPath;

import java.util.*;
import java.util.stream.Collectors;

public class NetworkDelayByDijkstra {

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> graph = Arrays.stream(times)
            .map(time -> new Edge(time[0], time[1], time[2]))
            .collect(Collectors.groupingBy(e -> e.from));

        Queue<int[]> vertices = new PriorityQueue<>(Comparator.comparingInt(ar -> ar[0]));
        vertices.add(new int[]{0, k});
        Map<Integer, Integer> weights = new HashMap<>();

        while (!vertices.isEmpty()) {
            int[] weightAndVertex = vertices.remove();
            int weight = weightAndVertex[0];
            int from = weightAndVertex[1];
            if (weights.containsKey(from)) {
                continue;
            }
            weights.put(from, weight);

            List<Edge> edges = graph.get(from);
            if (edges == null || edges.isEmpty()) {
                continue;
            }

            for (Edge edge : edges) {
                int to = edge.to;
                if (!weights.containsKey(to)) {
                    vertices.add(new int[]{weight + edge.weight, to});
                }
            }
        }

        if (weights.size() != n) {
            return -1;
        }

        int res = 0;
        for (int weight : weights.values()) {
            res = Math.max(res, weight);
        }

        return res;
    }

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
