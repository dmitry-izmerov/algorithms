package ru.demi.algorithms.leetcode.topInterview150.matrix;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
 * the British mathematician John Horton Conway in 1970."
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
 * dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 * following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where
 * births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 * Example 1:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * Example 2:
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        var moves = new int[][] {
                { -1, -1 },
                { -1, 0 },
                { -1, 1 },
                { 0, 1 },
                { 1, 1 },
                { 1, 0 },
                { 1, -1 },
                { 0, -1 },
        };
        var rows = board.length;
        var cols = board[0].length;
        for (var row = 0; row < rows; row++) {
            for (var col = 0; col < cols; col++) {
                var alive = 0;
                for (var move : moves) {
                    var nextI = row + move[0];
                    var nextJ = col + move[1];
                    if (nextI >= 0 && nextI < rows && nextJ >=0 && nextJ < cols && Math.abs(board[nextI][nextJ]) == 1) {
                        alive++;
                    }
                }

                var isAliveCell = board[row][col] == 1;
                if (isAliveCell && alive < 2) {
                    board[row][col] = -1;
                } else if (isAliveCell && alive > 3) {
                    board[row][col] = -1;
                } else if (!isAliveCell && alive == 3) {
                    board[row][col] = 2;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }
}
