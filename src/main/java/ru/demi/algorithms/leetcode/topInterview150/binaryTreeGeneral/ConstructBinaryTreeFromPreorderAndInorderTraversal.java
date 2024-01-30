package ru.demi.algorithms.leetcode.topInterview150.binaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private int[] preorder;
    private Map<Integer, Integer> map;
    private int preorderIdx;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.map = new HashMap<>();
        preorderIdx = 0;

        var idx = 0;
        for (var v : inorder) {
            map.put(v, idx++);
        }
        return build(0, inorder.length - 1);
    }

    TreeNode build(int left, int right) {
        if (left > right) return null;
        var val = preorder[preorderIdx++];
        var node = new TreeNode(val);
        node.left = build(left, map.get(val) - 1);
        node.right = build(map.get(val) + 1, right);
        return node;
    }
}
