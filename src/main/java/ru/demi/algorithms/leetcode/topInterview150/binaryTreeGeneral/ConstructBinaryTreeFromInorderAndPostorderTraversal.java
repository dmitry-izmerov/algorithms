package ru.demi.algorithms.leetcode.topInterview150.binaryTreeGeneral;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder
 * is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int[] postorder;
    private Map<Integer, Integer> map;
    private int postorderIdx;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postorderIdx = postorder.length - 1;
        this.map = new HashMap<>();

        var idx = 0;
        for (var v : inorder) {
            map.put(v, idx++);
        }

        return build(0, inorder.length - 1);
    }

    TreeNode build(int left, int right) {
        if (left > right) return null;

        var val = postorder[postorderIdx--];
        var node = new TreeNode(val);
        node.right = build(map.get(val) + 1, right);
        node.left = build(left, map.get(val) - 1);
        return node;
    }
}
