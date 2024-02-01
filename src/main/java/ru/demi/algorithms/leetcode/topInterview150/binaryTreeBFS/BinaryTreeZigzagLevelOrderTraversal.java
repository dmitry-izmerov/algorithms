package ru.demi.algorithms.leetcode.topInterview150.binaryTreeBFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to
 * right, then right to left for the next level and alternate between).
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        var res = new LinkedList<List<Integer>>();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var isLeftToRight = true;
        while (!q.isEmpty()) {
            var size = q.size();
            var list = new LinkedList<Integer>();
            for (var i = 0; i < size; i++) {
                var node = q.remove();
                if (isLeftToRight) {
                    list.add(node.val);
                } else {
                    list.push(node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
            isLeftToRight = !isLeftToRight;
        }
        return res;
    }
}
