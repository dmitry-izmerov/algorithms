package ru.demi.algorithms.leetcode.topInterview150.math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -10^4 <= xn <= 10^4
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) return 1;

        var num = (long) n;
        if (num < 0) {
            num *= -1;
            x = 1 / x;
        }

        var res = 1d;
        while (num != 0) {
            if (num % 2 == 1) {
                res *= x;
                num--;
            }
            x = x * x;
            num = num / 2;
        }

        return res;
    }
}
