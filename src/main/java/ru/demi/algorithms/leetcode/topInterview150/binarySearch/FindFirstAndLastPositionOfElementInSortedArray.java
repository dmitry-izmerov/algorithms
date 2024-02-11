package ru.demi.algorithms.leetcode.topInterview150.binarySearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
 * target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] { -1, -1 };

        this.nums = nums;
        this.target = target;
        var left = findBound(true);
        if (left == -1) {
            return new int[] { -1, -1 };
        }
        var right = findBound(false);
        return new int[] { left, right };
    }

    int findBound(boolean isLeft) {
        var lo = 0;
        var hi = nums.length - 1;
        while (lo <= hi) {
            var mid = (lo + hi) / 2;
            var midV = nums[mid];
            if (target == midV) {
                if (isLeft) {
                    if (mid == lo || nums[mid - 1] != target) {
                        return mid;
                    }
                    hi = mid - 1;
                } else {
                    if (mid == hi || nums[mid + 1] != target) {
                        return mid;
                    }
                    lo = mid + 1;
                }
            } else if (target < midV) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
