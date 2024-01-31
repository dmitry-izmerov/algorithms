package ru.demi.algorithms.leetcode.topInterview150.binaryTreeGeneral;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 10^5].
 * -10^9 <= Node.val <= 10^9
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
public class LowestCommonAncestorOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var stack = new LinkedList<TreeNode>();
        var childToParent = new HashMap<TreeNode, TreeNode>();

        stack.push(root);
        childToParent.put(root, null);
        while (!childToParent.containsKey(p) || !childToParent.containsKey(q)) {
            var node = stack.pop();
            if (node.left != null) {
                childToParent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                childToParent.put(node.right, node);
                stack.push(node.right);
            }
        }

        var ancestors = new HashSet<TreeNode>();
        while (p != null) {
            ancestors.add(p);
            p = childToParent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = childToParent.get(q);
        }

        return q;
    }
}
