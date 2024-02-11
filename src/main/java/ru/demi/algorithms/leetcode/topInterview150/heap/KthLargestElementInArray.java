package ru.demi.algorithms.leetcode.topInterview150.heap;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 *
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 * 1 <= k <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 */
public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(k + 1);
        for (var n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.remove();
    }
}
