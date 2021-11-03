package ru.demi.algorithms.leetcode.yandex;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroPointer = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[zeroPointer] = nums[i];
                ++zeroPointer;
            }
        }

        for (int i = zeroPointer; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
