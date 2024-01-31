package ru.demi.algorithms.leetcode.topInterview150.binaryTreeBFS;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10^-5 of the actual answer will be accepted.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 */
public class AverageOfLevelsInBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);

        var result = new LinkedList<Double>();
        while (!q.isEmpty()) {
            var sum = 0d;
            var count = 0;
            var size = q.size();
            for (var i = 0; i < size; i++) {
                var node = q.remove();
                count++;
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(sum / count);
        }

        return result;
    }
}
