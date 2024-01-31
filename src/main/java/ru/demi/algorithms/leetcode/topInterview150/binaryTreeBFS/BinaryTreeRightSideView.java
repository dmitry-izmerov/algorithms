package ru.demi.algorithms.leetcode.topInterview150.binaryTreeBFS;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes
 * you can see ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        var q = new LinkedList<TreeNode>();
        q.add(root);
        var result = new LinkedList<Integer>();
        while (!q.isEmpty()) {
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var node = q.remove();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return result;
    }
}
