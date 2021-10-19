package ru.demi.algorithms.leetcode.graphs.bfs;

import java.util.*;

public class NaryTreeTraversal {

    // Given class
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        List<List<Integer>> values = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node node = queue.remove();
                list.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
            }
            if (!list.isEmpty()) {
                values.add(list);
            }
        }
        return values;
    }
}
