package ru.demi.algorithms.leetcode.graphs.shortestPath;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implemented by improved Bellman-Ford algorithm with queue - "the Shortest Path Faster Algorithm" (SPFA).
 */
public class PathWithMinimumTotalEffort {

    private static final int[][] ijDiffs = new int[][]{
        {0, -1},
        {0, 1},
        {-1, 0},
        {1, 0}
    };

    public static int getMinimumEffortPath(int[][] heights) {
        Map<Node, List<Path>> paths = new HashMap<>();
        int rows = heights.length - 1;
        for (int i = 0; i <= rows; ++i) {
            int columns = heights[i].length - 1;
            for (int j = 0; j <= columns; ++j) {
                Node from = new Node(i, j);
                int row = i;
                int column = j;
                List<Path> pathsForNode = Stream.of(ijDiffs)
                    .map(ar -> new Node(row + ar[0], column + ar[1]))
                    .filter(n -> n.i() >= 0 && n.i() <= rows && n.j() >= 0 && n.j() <= columns)
                    .map(to -> new Path(from, to, Math.abs(heights[to.i()][to.j()] - heights[from.i()][from.j()])))
                    .collect(Collectors.toList());
                paths.put(from, pathsForNode);
            }
        }

        Map<Node, Integer> efforts = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> inQueue = new HashSet<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node from = queue.remove();
            for (Path p : paths.get(from)) {
                int sumEffort = efforts.getOrDefault(from, 0) + p.effort();
                if (sumEffort < efforts.getOrDefault(p.to(), Integer.MAX_VALUE)) {
                    efforts.put(p.to(), sumEffort);
                    if (!inQueue.contains(p.to())) {
                        queue.add(p.to());
                        inQueue.add(p.to());
                    }
                }
            }
            inQueue.remove(from);
        }

        return efforts.getOrDefault(new Node(rows, heights[0].length - 1), 0);
    }

    private static record Node(int i, int j) {
    }

    private static record Path(Node from, Node to, int effort) {

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Path) obj;
            return Objects.equals(this.from, that.from) &&
                Objects.equals(this.to, that.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}
