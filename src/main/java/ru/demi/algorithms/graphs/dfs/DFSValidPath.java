package ru.demi.algorithms.graphs.dfs;

import java.util.*;

/**
 * There are no duplicate edges.
 * There are no self edges.
 */
public class DFSValidPath {

    public boolean check(int n, int[][] edges, int start, int end) {
        DFSGraph graph = new DFSGraph(n, edges);
        return graph.isValidPath(start, end);
    }

    static class DFSGraph {
        private final List<List<Integer>> connections = new ArrayList<>();

        DFSGraph(int n, int[][] edges) {
            for (int i = 0; i < n; ++i) {
                connections.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                connections.get(edge[0]).add(edge[1]);
                connections.get(edge[1]).add(edge[0]);
            }
        }

        boolean isValidPath(int from, int to) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(from);
            Set<Integer> visited = new HashSet<>();
            while (!stack.isEmpty()) {
                int next = stack.pop();
                if (next == to) {
                    return true;
                }
                visited.add(next);
                connections.get(next).forEach(i -> {
                    if (!visited.contains(i)) {
                        stack.push(i);
                    }
                });
            }
            return false;
        }
    }
}
