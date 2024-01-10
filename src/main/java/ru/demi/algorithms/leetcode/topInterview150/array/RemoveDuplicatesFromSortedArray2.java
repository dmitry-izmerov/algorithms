package ru.demi.algorithms.leetcode.topInterview150.array;

/**
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
 * such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates, then the first k elements of nums
 * should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 *
 * Examples
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 */
public class RemoveDuplicatesFromSortedArray2 {

    static int removeDuplicates(int[] nums) {
        int i = 0;
        for (var n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
