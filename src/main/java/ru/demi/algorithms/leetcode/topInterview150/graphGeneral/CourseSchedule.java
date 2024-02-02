package ru.demi.algorithms.leetcode.topInterview150.graphGeneral;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you <b>must</b> take course bi first if you want to
 * take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So
 * it is impossible.
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    Set<Integer> visited;
    Set<Integer> inStack;
    List<List<Integer>> adjList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new HashSet<>();
        inStack = new HashSet<>();
        adjList = new ArrayList<>(numCourses);
        for (var i = 0; i < numCourses; i++) {
            adjList.add(new LinkedList<>());
        }

        for (var pr : prerequisites) {
            adjList.get(pr[0]).add(pr[1]);
        }

        for (var i = 0; i < numCourses; i++) {
            if (hasCycle(i)) {
                return false;
            }
        }

        return true;
    }

    boolean hasCycle(int course) {
        if (inStack.contains(course)) return true;
        if (visited.contains(course)) return false;

        visited.add(course);
        inStack.add(course);
        for (var c : adjList.get(course)) {
            if (hasCycle(c)) {
                return true;
            }
        }
        inStack.remove(course);

        return false;
    }
}
