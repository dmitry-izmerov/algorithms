package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner
 * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only
 * move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any
 * square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
 *
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePaths2 {
    int[][] grid;
    Map<String, Integer> cache;
    int rows, cols;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        cache = new HashMap<>();
        rows = grid.length;
        cols = grid[0].length;
        var res = dp(0, 0);
        return Math.max(res, 0);
    }

    int dp(int i, int j) {
        if (i >= rows || j >= cols) return -1;
        if (grid[i][j] == 1) return -1;
        var key = i + ":" + j;
        if (cache.containsKey(key)) return cache.get(key);
        if (i == rows - 1 && j == cols - 1) return 1;

        var res = 0;
        var down = dp(i + 1, j);
        if (down > 0) res += down;
        var right = dp(i, j + 1);
        if (right > 0) res += right;
        cache.put(key, res);
        return res;
    }
}
