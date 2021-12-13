package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
class ContainsDuplicate {

    public boolean check(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}