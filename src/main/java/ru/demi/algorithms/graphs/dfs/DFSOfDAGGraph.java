package ru.demi.algorithms.graphs.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class DFSOfDAGGraph {
    private final List<List<Integer>> connections = new ArrayList<>();

    DFSOfDAGGraph(int[][] graph) {
        for (int[] vertices : graph) {
            List<Integer> list = new ArrayList<>();
            connections.add(list);
            for (int vertex : vertices) {
                list.add(vertex);
            }
        }
    }

    public List<List<Integer>> getAllPaths(int from, int to) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        List<Integer> initial = new ArrayList<>();
        initial.add(from);
        stack.add(initial);
        while (!stack.isEmpty()) {
            List<Integer> next = stack.pop();
            int last = next.get(next.size() - 1);
            if (last == to) {
                result.add(next);
            } else {
                for (int vertex : connections.get(last)) {
                    List<Integer> nextWithVertex = new ArrayList<>(next);
                    nextWithVertex.add(vertex);
                    stack.push(nextWithVertex);
                }
            }
        }
        return result;
    }
}