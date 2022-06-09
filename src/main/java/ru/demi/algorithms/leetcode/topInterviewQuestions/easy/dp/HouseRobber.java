package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 400
 */
public class HouseRobber {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(getMax(nums, 0), getMax(nums, 1));
    }

    private int getMax(int[] nums, int next) {
        if (next >= nums.length) {
            return 0;
        }

        Integer memoized = memo.getOrDefault(next, null);
        if (memoized != null) {
            return memoized;
        }

        int current = nums[next];
        int from = next + 2;
        int max = current;
        for (int i = from; i < nums.length; i++) {
            max = Math.max(max, getMax(nums, i) + current);
        }
        memo.putIfAbsent(next, max);
        return max;
    }
}
