package ru.demi.algorithms.leetcode.topInterview150.binaryTreeGeneral;

import java.util.LinkedList;

/**
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
 * be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its
 * next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers,
 * with '#' signifying the end of each level.
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 6000].
 * -100 <= Node.val <= 100
 */
public class PopulatingNextRightPointersInEachNode2 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) return null;

        var q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            var size = q.size();
            Node next = null;
            for (var i = 0; i < size; i++) {
                var cur = q.remove();
                cur.next = next;
                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                next = cur;
            }

        }

        return root;
    }
}
