package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the
 * sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
public class MinimumPathSum {
    int[][] grid;
    Map<String, Integer> cache;
    int rows, cols;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        cache = new HashMap<>();
        return dp(0, 0);
    }

    int dp(int i, int j) {
        if (i >= rows || j >= cols) return -1;
        if (i == rows - 1 && j == cols - 1) return grid[i][j];
        var key = i + ":" + j;
        if (cache.containsKey(key)) return cache.get(key);

        var down = dp(i + 1, j);
        down = down == -1 ? Integer.MAX_VALUE : down;
        var right = dp(i, j + 1);
        right = right == -1 ? Integer.MAX_VALUE : right;
        var res = grid[i][j] + Math.min(down, right);
        cache.put(key, res);
        return res;
    }
}
