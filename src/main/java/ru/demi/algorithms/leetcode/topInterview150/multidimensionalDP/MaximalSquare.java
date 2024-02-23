package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example 1:
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * Example 2:
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * Example 3:
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] is '0' or '1'.
 */
public class MaximalSquare {
    char[][] matrix;
    Map<String, Integer> cache;

    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        cache = new HashMap<>();
        var max = 0;
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, dp(i, j));
                }
            }
        }
        return max * max;
    }

    int dp(int i, int j) {
        var key = i + ":" + j;
        if (cache.containsKey(key)) return cache.get(key);

        if (i == matrix.length || j == matrix[0].length) {
            return 0;
        }

        if (matrix[i][j] == '0') {
            return 0;
        }

        var right = dp(i, j + 1);
        var bottom = dp(i + 1, j);
        var diagonal = dp(i + 1, j + 1);
        var res = 1 + Math.min(right, Math.min(bottom, diagonal));
        cache.put(key, res);
        return res;
    }
}
