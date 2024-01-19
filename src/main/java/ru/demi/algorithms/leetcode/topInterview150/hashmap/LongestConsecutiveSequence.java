package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.HashSet;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();
        for (var n : nums) {
            set.add(n);
        }

        var max = 0;
        for (var n : set) {
            if (set.contains(n - 1)) {
                continue;
            }
            var curLen = 1;
            var num = n;
            while (set.contains(num + 1)) {
                num++;
                curLen++;
            }
            max = Math.max(max, curLen);
        }
        return max;
    }
}
