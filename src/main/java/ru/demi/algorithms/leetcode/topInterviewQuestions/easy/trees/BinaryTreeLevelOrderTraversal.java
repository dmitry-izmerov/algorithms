package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.trees;

import java.util.*;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 2000].
 * - -1000 <= Node.val <= 1000
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            var size = queue.size();
            for (var i = 0; i < size; ++i) {
                var node = queue.remove();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty()) {
                list.add(level);
            }
        }

        return list;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
