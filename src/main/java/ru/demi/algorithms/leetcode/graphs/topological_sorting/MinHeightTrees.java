package ru.demi.algorithms.leetcode.graphs.topological_sorting;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinHeightTrees {

    public static List<Integer> findMinHeightRoots(int n, int[][] edges) {
        if (n < 2) {
            return Collections.singletonList(0);
        }

        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        for (int[] edge : edges) {
            Stream.of(new int[]{0, 1}, new int[]{1, 0}).forEach(idxes -> {
                int key = edge[idxes[0]];
                Set<Integer> nodes = adjacencyMap.getOrDefault(key, new HashSet<>());
                nodes.add(edge[idxes[1]]);
                adjacencyMap.put(key, nodes);
            });
        }

        List<Integer> leaves = adjacencyMap.entrySet().stream().filter(e -> e.getValue().size() == 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        int remainingNodes = n;
        while (remainingNodes > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                int neighbour = adjacencyMap.get(leaf).iterator().next();
                Set<Integer> nodes = adjacencyMap.get(neighbour);
                nodes.remove(leaf);
                if (nodes.size() == 1) {
                    newLeaves.add(neighbour);
                }
            }

            remainingNodes -= leaves.size();
            leaves = newLeaves;
        }

        return leaves;
    }
}
