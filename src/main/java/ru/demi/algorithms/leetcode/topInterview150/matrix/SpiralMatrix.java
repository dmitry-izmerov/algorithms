package ru.demi.algorithms.leetcode.topInterview150.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        var moves = new int[][] {
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };

        var res = new ArrayList<Integer>();
        var curMove = 0;
        var rows = matrix.length;
        var cols = matrix[0].length;
        var visited = 101;
        res.add(matrix[0][0]);
        matrix[0][0] = visited;
        var dirChange = 0;
        for (int i = 0, j = 0; dirChange < 2;) {
            var newI = i + moves[curMove][0];
            var newJ = j + moves[curMove][1];
            while (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && matrix[newI][newJ] != visited) {
                i = newI;
                j = newJ;
                var val = matrix[i][j];
                res.add(val);
                matrix[i][j] = visited;
                newI = i + moves[curMove][0];
                newJ = j + moves[curMove][1];
                dirChange = 0;
            }

            curMove += 1;
            curMove %= moves.length;
            dirChange++;
        }

        return res;
    }
}
