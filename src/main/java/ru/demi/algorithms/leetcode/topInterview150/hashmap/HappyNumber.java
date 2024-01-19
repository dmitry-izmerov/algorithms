package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        var set = new HashSet<Integer>();
        var rest = n;
        while (rest != 1 && !set.contains(rest)) {
            set.add(rest);
            var sum = 0;
            while (rest != 0) {
                var right = rest % 10;
                rest = rest / 10;
                sum += right * right;
            }
            rest = sum;
        }
        return rest == 1;
    }
}
