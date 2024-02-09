package ru.demi.algorithms.leetcode.topInterview150.binarySearch;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        var lo = 0;
        var hi = nums.length - 1;
        while (lo <= hi) {
            var mid = (lo + hi) / 2;
            var midVal = nums[mid];
            if (midVal == target) return mid;

            if (target < midVal) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
