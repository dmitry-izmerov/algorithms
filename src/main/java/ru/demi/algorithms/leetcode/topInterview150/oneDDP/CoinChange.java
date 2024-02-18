package ru.demi.algorithms.leetcode.topInterview150.oneDDP;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing
 * a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by
 * any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */
public class CoinChange {
    int[] coins;
    Map<Integer, Integer> cache;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        cache = new HashMap<>();
        return minCoins(amount);
    }

    int minCoins(int amount) {
        if (cache.containsKey(amount)) return cache.get(amount);
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        var min = Integer.MAX_VALUE;
        for (var c : coins) {
            var curMin = minCoins(amount - c);
            if (curMin < 0) {
                continue;
            }
            min = Math.min(min, curMin + 1);
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        cache.put(amount, min);
        return min;
    }
}
