package ru.demi.algorithms.leetcode.topInterview150.array;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
 * at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Examples
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4. Total profit is 4.
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 *
 * Constraints:
 * 1 <= prices.length <= 3 * 10^4
 * 0 <= prices[i] <= 10^4
 */
public class BestTimeBuySellStock2 {

    public int maxProfit(int[] prices) {
        var profit = 0;
        var deal = new Deal(prices[0], prices[0]);
        var prev = prices[0];
        var profitTaken = false;
        for (var p : prices) {
            if (prev > p) {
                profit += deal.profit();
                deal = new Deal(p, p);
                profitTaken = true;
            }
            if (p > deal.max) {
                deal = deal.withMax(p);
                profitTaken = false;
            }
            prev = p;
        }

        if (!profitTaken) {
            profit += deal.profit();
        }

        return profit;
    }

    record Deal(int min, int max) {
        int profit() {
            return max - min;
        }
        Deal withMax(int val) {
            return new Deal(min, val);
        }
    }
}
