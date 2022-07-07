package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.array;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share
 * of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Constraints:
 * - 1 <= prices.length <= 3 * 10^4
 * - 0 <= prices[i] <= 10^4
 */
public class BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        var profit = 0;
        var pair = new Pair(prices[0], prices[0]);
        int prev = prices[0];
        boolean profitTaken = false;
        for (int i = 1; i < prices.length; i++) {
            var price = prices[i];
            if (prev > price) {
                profit += pair.getDiff();
                pair = new Pair(price, price);
                profitTaken = true;
            }
            if (price > pair.max) {
                pair.max = price;
                profitTaken = false;
            }
            prev = price;
        }
        if (!profitTaken) {
            profit += pair.getDiff();
        }

        return profit;
    }

    private static class Pair {
        int min;
        int max;

        Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getDiff() {
            return max - min;
        }
    }
}
