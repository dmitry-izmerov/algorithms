package ru.demi.algorithms.leetcode.topInterview150.graphGeneral;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of
 * them. If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the
 * correct course order is [0,1].
 * Example 2:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * All the pairs [ai, bi] are distinct.
 */
public class CourseSchedule2 {
    Map<Integer, List<Integer>> graph;
    int numCourses;
    Set<Integer> visited;
    Set<Integer> inStack;
    List<Integer> path;
    boolean isPossible;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.graph = new HashMap<>();
        this.numCourses = numCourses;
        visited = new HashSet<>();
        inStack = new HashSet<>();
        path = new LinkedList<>();
        isPossible = true;

        for (var pr : prerequisites) {
            var a = pr[0];
            var b = pr[1];
            var list = graph.getOrDefault(a, new LinkedList<>());
            list.add(b);
            graph.put(a, list);
        }

        for (var i = 0; i < numCourses; i++) {
            dfs(i);
        }

        return isPossible ? path.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    void dfs(int course) {
        if (!isPossible) return;
        if (inStack.contains(course)) {
            isPossible = false;
            return;
        }
        if (visited.contains(course)) return;

        visited.add(course);
        inStack.add(course);
        for (var node : graph.getOrDefault(course, new LinkedList<>())) {
            dfs(node);
        }

        inStack.remove(course);
        path.add(course);
    }
}
