package ru.demi.algorithms.leetcode.topInterview150.divideAndConquer;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 *
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayToBST {
    int[] nums;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return build(0, nums.length - 1);
    }

    TreeNode build(int low, int high) {
        if (low > high) return null;

        var middle = (low + high) / 2;
        var left = build(low, middle - 1);
        var node = new TreeNode(nums[middle]);
        var right = build(middle + 1, high);
        node.left = left;
        node.right = right;
        return node;
    }
}
