package ru.demi.algorithms.leetcode.topInterview150.graphGeneral;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
 * and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer
 * for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and
 * that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for
 * them.
 *
 * Example 1:
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],
 * ["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 * Constraints:
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {
    private Map<String, Map<String, Double>> nodes;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        nodes = new HashMap<>();
        for (var i = 0; i < equations.size(); i++) {
            var e = equations.get(i);
            var a = e.get(0);
            var b = e.get(1);
            var v = values[i];
            var mapA = nodes.getOrDefault(a, new HashMap<>());
            mapA.put(b, v);
            nodes.put(a, mapA);
            var mapB = nodes.getOrDefault(b, new HashMap<>());
            mapB.put(a, 1/v);
            nodes.put(b, mapB);
        }

        var resAr = new double[queries.size()];
        for (var i = 0; i < queries.size(); i++) {
            var q = queries.get(i);
            var a = q.get(0);
            var b = q.get(1);
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                resAr[i] = -1d;
            } else if (a.equals(b)) {
                resAr[i] = 1d;
            } else {
                resAr[i] = calc(a, b, 1d, new HashSet<>());
            }
        }
        return resAr;
    }

    Double calc(String cur, String end, double total, Set<String> visited) {
        var res = -1d;
        visited.add(cur);

        var neighbors = nodes.get(cur);
        if (neighbors.containsKey(end)) {
            res = total * neighbors.get(end);
        } else {
            for (var e : neighbors.entrySet()) {
                var next = e.getKey();
                if (visited.contains(next)) continue;

                res = calc(next, end, total * e.getValue(), visited);
                if (res != -1d) break;
            }
        }

        visited.remove(cur);
        return res;
    }
}
