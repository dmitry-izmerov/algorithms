package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.design;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 *
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 *
 * Constraints:
 * 1 <= nums.length <= 50
 * -10^6 <= nums[i] <= 10^6
 * All the elements of nums are unique.
 * At most 10^4 calls in total will be made to reset and shuffle.
 */
public class ShuffleArray {

    private final int[] nums;
    private long nextPermutation = 0;
    private long pointer = 0;
    private long factorial;

    public ShuffleArray(int[] nums) {
        factorial = getFactorial(nums.length);
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        var permutation = getPermutation(nums, new ArrayList<>());
        pointer = 0;
        return permutation.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> getPermutation(int[] nums, List<Integer> collector) {
        if (nums.length == 0) {
            if (pointer == nextPermutation) {
                ++nextPermutation;
                nextPermutation %= factorial;
                return collector;
            }
            ++pointer;
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            var newCollector = new ArrayList<>(collector);
            var newNums = new int[nums.length - 1];
            var firstPartLength = i;
            System.arraycopy(nums, 0, newNums, 0, firstPartLength);
            var secondPartLength = nums.length - i - 1;
            System.arraycopy(nums, i + 1, newNums, firstPartLength, secondPartLength);
            newCollector.add(nums[i]);
            var permutation = getPermutation(newNums, newCollector);
            if (permutation != null) {
                return permutation;
            }
        }

        return null;
    }

    private long getFactorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
