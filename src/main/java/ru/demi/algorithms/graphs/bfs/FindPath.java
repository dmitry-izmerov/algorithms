package ru.demi.algorithms.graphs.bfs;

import java.util.*;

public class FindPath {

    public static boolean isValidPath(int n, int[][] edges, int start, int end) {
        BFSGraph graph = new BFSGraph(n, edges);
        return graph.isValidPath(start, end);
    }

    static class BFSGraph {
        private final List<List<Integer>> connections;

        BFSGraph(int n, int[][] edges) {
            connections = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                connections.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                connections.get(edge[0]).add(edge[1]);
                connections.get(edge[1]).add(edge[0]);
            }
        }

        boolean isValidPath(int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            Set<Integer> visited = new HashSet<>();

            while (!queue.isEmpty()) {
                int current = queue.remove();

                if (current == end) {
                    return true;
                }
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);
                queue.addAll(connections.get(current));
            }

            return false;
        }
    }
}
