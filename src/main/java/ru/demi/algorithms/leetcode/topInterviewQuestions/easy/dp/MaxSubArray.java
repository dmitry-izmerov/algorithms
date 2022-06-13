package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.dp;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 *
 * Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^4 <= nums[i] <= 10^4
 */
public class MaxSubArray {

    private int maxValue = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        calcMax(nums, nums.length - 1);
        return maxValue;
    }

    private int calcMax(int[] nums, int i) {
        if (i == 0) {
            int max = nums[0];
            maxValue = Math.max(this.maxValue, max);
            return max;
        }
        int max = Math.max(calcMax(nums, i - 1) + nums[i], nums[i]);
        maxValue = Math.max(this.maxValue, max);
        return max;
    }
}
