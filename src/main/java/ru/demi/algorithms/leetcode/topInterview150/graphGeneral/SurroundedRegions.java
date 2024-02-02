package ru.demi.algorithms.leetcode.topInterview150.graphGeneral;

import java.util.LinkedList;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example 1:
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Notice that an 'O' should not be flipped if:
 * - It is on the border, or
 * - It is adjacent to an 'O' that should not be flipped.
 * The bottom 'O' is on the border, so it is not flipped.
 * The other three 'O' form a surrounded region, so they are flipped.
 * Example 2:
 * Input: board = [["X"]]
 * Output: [["X"]]
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class SurroundedRegions {
    char[][] board;
    int rows;
    int cols;

    record Cell(int i, int j) {}

    public void solve(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        var borders = new LinkedList<Cell>();
        for (var i = 0; i < rows; i++) {
            borders.add(new Cell(i, 0));
            borders.add(new Cell(i, cols - 1));
        }
        for (var j = 0; j < cols; j++) {
            borders.add(new Cell(0, j));
            borders.add(new Cell(rows - 1, j));
        }

        for (var border : borders) {
            dfs(border.i, border.j);
        }

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                var ch = board[i][j];
                if (ch == 'O') {
                    board[i][j] = 'X';
                }
                if (ch == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(int i, int j) {
        if (board[i][j] != 'O') return;

        board[i][j] = 'B';
        if (i > 0) dfs(i - 1, j);
        if (j < cols - 1) dfs(i, j + 1);
        if (i < rows - 1) dfs(i + 1, j);
        if (j > 0) dfs(i, j - 1);
    }
}
