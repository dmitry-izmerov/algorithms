package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.dp;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 */
public class BestTime {
    private int maxProfit = 0;

    public int maxProfit(int[] prices) {
        getMinMax(prices, prices.length - 1);
        return maxProfit;
    }

    private int[] getMinMax(int[] prices, int i) {
        int current = prices[i];
        if (i == 0) {
            return new int[]{current, current};
        }
        int[] minMax = getMinMax(prices, i - 1);
        if (current < minMax[0]) {
            minMax[0] = current;
            minMax[1] = current;
        } else if (current > minMax[1]) {
            minMax[1] = current;
            maxProfit = Math.max(maxProfit, minMax[1] - minMax[0]);
        }
        return minMax;
    }
}
