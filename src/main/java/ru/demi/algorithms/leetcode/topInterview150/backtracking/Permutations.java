package ru.demi.algorithms.leetcode.topInterview150.backtracking;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any
 * order.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class Permutations {
    List<List<Integer>> res;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        this.nums = nums;
        permute(new LinkedHashSet<>());
        return res;
    }

    void permute(Set<Integer> acc) {
        if (acc.size() == nums.length) {
            res.add(List.copyOf(acc));
            return;
        }

        for (int num : nums) {
            if (acc.contains(num)) continue;
            acc.add(num);
            permute(acc);
            acc.remove(num);
        }
    }
}
