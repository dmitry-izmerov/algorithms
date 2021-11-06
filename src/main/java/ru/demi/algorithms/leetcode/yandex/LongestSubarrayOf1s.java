package ru.demi.algorithms.leetcode.yandex;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array.
 * Return 0 if there is no such subarray.
 */
public class LongestSubarrayOf1s {

    public int longestSubarray(int[] nums) {
        List<Integer> counters = new ArrayList<>();

        int counter = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                ++counter;
            } else {
                counters.add(counter);
                counter = 0;
            }
        }
        if (counter > 0) {
            counters.add(counter);
        }

        if (counters.size() == 1 && counter == nums.length) {
            return counter - 1;
        }

        if (counters.size() < 2) {
            return 0;
        }

        int max = 0;
        for (int prev = 0, cur = 1; cur < counters.size(); ++prev, ++cur) {
            int sum = counters.get(prev) + counters.get(cur);
            max = Math.max(sum, max);
        }
        return max;
    }
}
