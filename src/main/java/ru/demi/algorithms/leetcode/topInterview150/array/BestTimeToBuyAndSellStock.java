package ru.demi.algorithms.leetcode.topInterview150.array;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Examples
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        var profit = 0;
        var min = Integer.MAX_VALUE;
        for (var price : prices) {
            if (price < min) {
                min = price;
            } else {
                profit = Math.max(profit, price - min);
            }
        }

        return profit;
    }
}
