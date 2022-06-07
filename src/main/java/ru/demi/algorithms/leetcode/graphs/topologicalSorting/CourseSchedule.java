package ru.demi.algorithms.leetcode.graphs.topologicalSorting;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CourseSchedule {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; ++i) {
                res[i] = i;
            }
            return res;
        }

        Map<Integer, List<Edge>> edgesMap = Arrays.stream(prerequisites)
            .map(ar -> new Edge(ar[1], ar[0]))
            .collect(Collectors.groupingBy(e -> e.from));

        Map<Integer, Long> inDegrees = Arrays.stream(prerequisites)
            .map(ar -> new Edge(ar[1], ar[0]))
            .collect(Collectors.groupingBy(e -> e.to, Collectors.counting()));

        List<Integer> sources = IntStream.range(0, numCourses)
            .boxed()
            .filter(Predicate.not(inDegrees::containsKey))
            .collect(Collectors.toList());

        if (sources.isEmpty()) {
            return new int[0];
        }

        Queue<Integer> queue = new LinkedList<>(sources);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (Edge edge : edgesMap.getOrDefault(vertex, Collections.emptyList())) {
                int to = edge.to;
                inDegrees.compute(to, (k, v) -> --v);
                long inDegree = inDegrees.get(to);
                if (inDegree == 0) {
                    queue.add(to);
                }
            }
            res.add(vertex);
        }

        if (res.size() < numCourses) {
            return new int[0];
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private static class Edge {
        final int from;
        final int to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
