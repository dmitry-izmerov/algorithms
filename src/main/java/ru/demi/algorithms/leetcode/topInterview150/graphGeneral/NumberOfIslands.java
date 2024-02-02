package ru.demi.algorithms.leetcode.topInterview150.graphGeneral;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of
 * islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may
 * assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    char[][] grid;
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        this.grid = grid;

        var numIslands = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;
        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    void dfs(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i + 1, j);
        dfs(i, j - 1);
    }
}
