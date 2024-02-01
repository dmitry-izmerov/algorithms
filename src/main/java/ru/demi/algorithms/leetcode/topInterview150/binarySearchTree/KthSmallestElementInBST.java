package ru.demi.algorithms.leetcode.topInterview150.binarySearchTree;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values
 * of the nodes in the tree.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 */
public class KthSmallestElementInBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    int left;
    public int kthSmallest(TreeNode root, int k) {
        left = k;
        return inorder(root);
    }

    Integer inorder(TreeNode node) {
        if (node == null) return null;

        var l = inorder(node.left);
        if (l != null) {
            return l;
        }
        if (--left == 0) {
            return node.val;
        }
        var r = inorder(node.right);
        if (r != null) {
            return r;
        }
        return null;
    }
}
