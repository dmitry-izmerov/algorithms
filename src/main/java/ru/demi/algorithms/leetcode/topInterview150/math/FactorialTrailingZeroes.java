package ru.demi.algorithms.leetcode.topInterview150.math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * Input: n = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 10^4
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        if (n < 0) return -1;

        var count = 0;
        for (var i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
