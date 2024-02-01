package ru.demi.algorithms.leetcode.topInterview150.binarySearchTree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    boolean isValid(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;

        if (low != null && node.val <= low) {
            return false;
        }

        if (high != null && node.val >= high) {
            return false;
        }

        return isValid(node.left, low, node.val) && isValid(node.right, node.val, high);
    }
}
