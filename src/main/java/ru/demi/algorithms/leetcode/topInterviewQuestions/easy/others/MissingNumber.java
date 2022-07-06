package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        var n = nums.length;
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return  0;
    }
}
