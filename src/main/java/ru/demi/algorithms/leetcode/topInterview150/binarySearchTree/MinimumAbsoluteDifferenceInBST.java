package ru.demi.algorithms.leetcode.topInterview150.binarySearchTree;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two
 * different nodes in the tree.
 *
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^4].
 * 0 <= Node.val <= 10^5
 */
public class MinimumAbsoluteDifferenceInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int minDiff;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        traverse(root);
        return minDiff;
    }

    void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(node.val - prev.val));
        }
        prev = node;
        traverse(node.right);
    }
}
