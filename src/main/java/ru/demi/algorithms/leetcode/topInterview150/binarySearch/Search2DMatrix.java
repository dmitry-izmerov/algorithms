package ru.demi.algorithms.leetcode.topInterview150.binarySearch;

/**
 * You are given an m x n integer matrix with the following two properties:
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class Search2DMatrix {
    int[][] matrix;
    int rows;
    int cols;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        var lo = 0;
        var hi = rows * cols - 1;
        while (lo <= hi) {
            var mid = (lo + hi) / 2;
            var midVal = getVal(mid);
            if (target == midVal) {
                return true;
            }
            if (target < midVal) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    int getVal(int idx) {
        var i = idx / cols;
        var j = idx % cols;
        return matrix[i][j];
    }
}
