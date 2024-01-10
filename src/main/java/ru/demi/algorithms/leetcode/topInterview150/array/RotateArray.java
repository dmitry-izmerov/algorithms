package ru.demi.algorithms.leetcode.topInterview150.array;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 * Examples:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        var len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] ar, int from, int to) {
        for (; from < to; from++, to--) {
            var temp = ar[from];
            ar[from] = ar[to];
            ar[to] = temp;
        }
    }
}
