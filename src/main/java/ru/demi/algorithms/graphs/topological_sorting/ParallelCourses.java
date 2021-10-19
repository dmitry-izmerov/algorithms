package ru.demi.algorithms.graphs.topological_sorting;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelCourses {

    public static int getMinimumSemesters(int n, int[][] relations) {
        if (n == 0) {
            return 0;
        }

        if (relations == null || relations.length == 0) {
            return 1;
        }

        Map<Integer, List<Integer>> adjacencyMap = Arrays.stream(relations)
            .collect(Collectors.groupingBy(r -> r[0], Collectors.mapping(r -> r[1], Collectors.toList())));

        Map<Integer, Long> inDegrees = Arrays.stream(relations)
            .collect(Collectors.groupingBy(r -> r[1], Collectors.counting()));

        List<Integer> sources = IntStream.rangeClosed(1, n)
            .boxed()
            .filter(Predicate.not(inDegrees::containsKey))
            .collect(Collectors.toList());

        if (sources.isEmpty()) {
            return -1;
        }

        int result = 0;
        int visitedNodes = 0;
        Queue<Integer> queue = new LinkedList<>(sources);
        while (!queue.isEmpty()) {
            int size = queue.size();
            visitedNodes += size;
            for (int i = 0; i < size; ++i) {
                int node = queue.remove();
                List<Integer> neighbours = adjacencyMap.getOrDefault(node, Collections.emptyList());
                for (Integer neighbour : neighbours) {
                    inDegrees.compute(neighbour, (k, v) -> v - 1);
                    if (inDegrees.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            ++result;
        }

        if (visitedNodes != n) {
            return -1;
        }

        return result;
    }
}
