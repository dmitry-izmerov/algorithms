package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the
 * current row, you may move to either index i or index i + 1 on the next row.
 *
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 *
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 */
public class Triangle {
    List<List<Integer>> triangle;
    Map<Cell, Integer> cache;

    record Cell(int i, int j) {}

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        cache = new HashMap<>();
        return dp(0, 0);
    }

    int dp(int i, int j) {
        var cell = new Cell(i, j);
        if (cache.containsKey(cell)) return cache.get(cell);
        if (i >= triangle.size() || j >= triangle.get(i).size()) return 0;

        var cur = triangle.get(i).get(j);
        var min = cur + Math.min(dp(i + 1, j), dp(i + 1, j + 1));
        cache.put(new Cell(i, j), min);

        return min;
    }
}
