package ru.demi.algorithms.leetcode.graphs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
public class AllPathsInDAG {

    public List<List<Integer>> getAllPathsSourceToEnd(int[][] graph) {
        BFSGraph g = new BFSGraph(graph);
        return g.getAllPaths(0, graph.length - 1);
    }

    static class BFSGraph {
        private final int[][] graph;

        BFSGraph(int[][] graph) {
            this.graph = graph;
        }

        public List<List<Integer>> getAllPaths(int from, int to) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> initial = new ArrayList<>();
            initial.add(from);
            queue.add(initial);
            while (!queue.isEmpty()) {
                List<Integer> next = queue.remove();
                int last = next.get(next.size() - 1);
                if (last == to) {
                    result.add(next);
                } else {
                    for (int vertex : graph[last]) {
                        List<Integer> nextWithVertex = new ArrayList<>(next);
                        nextWithVertex.add(vertex);
                        queue.add(nextWithVertex);
                    }
                }
            }
            return result;
        }
    }
}
