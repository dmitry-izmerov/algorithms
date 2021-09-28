package ru.demi.algorithms.graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node
 */
public class CloneGraph {
    private final Map<Integer, Node> nodes = new HashMap<>();

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (nodes.containsKey(node.val)) {
            return nodes.get(node.val);
        }
        Node newNode = new Node(node.val);
        nodes.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            Node newNeighbor = cloneGraph(neighbor);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
}
