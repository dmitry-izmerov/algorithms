package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Constraints:
 * - 1 <= n <= 45
 */
public class ClimbingStairs {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, res);
        return res;
    }
}
