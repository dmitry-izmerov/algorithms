package ru.demi.algorithms.leetcode.yandex;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquareOfSortedArrays {

    public int[] getSortedSquares(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        int left = 0;
        int right = size - 1;

        for (int i = size - 1; i >= 0; --i) {
            int num;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                num = nums[left];
                ++left;
            } else {
                num = nums[right];
                --right;
            }
            result[i] = num * num;
        }

        return result;
    }
}
