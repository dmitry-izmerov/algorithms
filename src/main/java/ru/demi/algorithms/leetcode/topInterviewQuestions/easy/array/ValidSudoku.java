package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 *
 * Constraints:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit 1-9 or '.'
 */
public class ValidSudoku {
    private static final char START = '1';
    private static final char END = '9';
    private static final int SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        for (var i = 0; i < SIZE; ++i) {
            var rowValidator = new Validator();
            var colValidator = new Validator();

            for (var j = 0; j < SIZE; ++j) {
                var rowVal = board[i][j];
                if (Character.isDigit(rowVal)) {
                    if (!rowValidator.isValid(rowVal)) {
                        return false;
                    }
                }

                var colVal = board[j][i];
                if (Character.isDigit(colVal)) {
                    if (!colValidator.isValid(colVal)) {
                        return false;
                    }
                }
            }
        }
        for (var i = 0; i < SIZE; i+=3) {
            for (var j = 0; j < SIZE; j+=3) {
                var squareValidator = new Validator();
                for (var r = 0; r < 3; r++) {
                    for (var c = 0; c < 3; c++) {
                        var val = board[i + r][j + c];
                        if (!Character.isDigit(val)) {
                            continue;
                        }
                        if (!squareValidator.isValid(val)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static class Validator {
        private final Set<Character> digits = new HashSet<>();

        public boolean isValid(char digit) {
            if (!inRange(digit) || digits.contains(digit)) {
                return false;
            }
            digits.add(digit);
            return true;
        }

        private boolean inRange(char n) {
            return n >= START && n <= END;
        }
    }
}
