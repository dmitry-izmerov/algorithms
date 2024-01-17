package ru.demi.algorithms.leetcode.topInterview150.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are
 * two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
    private static final int size = 9;
    private static final int start = 1;
    private static final int end = 9;

    public boolean isValidSudoku(char[][] board) {
        for (var i = 0; i < end; i++) {
            var rowValidator = new SudokuValidator();
            var colValidator = new SudokuValidator();

            for (var j = 0; j < end; j++) {
                var rowChar = board[i][j];

                if (Character.isDigit(rowChar) && !rowValidator.isValid(rowChar)) {
                    return false;
                }

                var colChar = board[j][i];
                if (Character.isDigit(colChar) && !colValidator.isValid(colChar)) {
                    return false;
                }
            }
        }

        for (var i = 0; i < end; i+=3) {
            for (var j = 0; j < end; j+=3) {
                var squareValidator = new SudokuValidator();
                for (var row = i; row < i + 3; row++) {
                    for (var col = j; col < j + 3; col++) {
                        var c = board[row][col];
                        if (Character.isDigit(c) && !squareValidator.isValid(c)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static class SudokuValidator {
        private final Set<Integer> digits = new HashSet<>();

        boolean isValid(char c) {
            var value = Character.getNumericValue(c);
            if (value < start || value > end) {
                return false;
            }
            if (digits.contains(value)) {
                return false;
            }
            digits.add(value);
            return true;
        }
    }
}
