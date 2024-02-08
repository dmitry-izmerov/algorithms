package ru.demi.algorithms.leetcode.topInterview150.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 */
public class WordSearch {
    char[][] board;
    String word;
    int rows;
    int cols;
    Set<Cell> visited;
    List<Cell> dirs = List.of(new Cell(-1, 0), new Cell(0, 1), new Cell(1, 0), new Cell(0, -1));

    record Cell(int i, int j) {}

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        visited = new HashSet<>();

        for (var i = 0; i < rows; i++) {
            for (var j = 0; j < cols; j++) {
                if (exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean exist(int i, int j, int idx) {
        if (idx >= word.length()) return true;

        if (i < 0 || i == rows || j < 0 || j == cols) {
            return false;
        }

        var cell = new Cell(i, j);
        if (visited.contains(cell) || board[i][j] != word.charAt(idx)) return false;

        visited.add(cell);

        for (var d : dirs) {
            var nextI = i + d.i;
            var nextJ = j + d.j;
            if (exist(nextI, nextJ, idx + 1)) return true;
        }

        visited.remove(cell);

        return false;
    }
}
