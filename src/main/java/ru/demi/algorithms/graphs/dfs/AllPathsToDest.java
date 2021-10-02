package ru.demi.algorithms.graphs.dfs;

import java.util.*;

public class AllPathsToDest {

    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        DFSSearch search = new DFSSearch(n, edges);
        return search.leadsToDestination(source, destination);
    }

    static class DFSSearch {
        private final List<Node> nodes;

        DFSSearch(int n, int[][] edges) {
            nodes = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) {
                nodes.add(new Node(i));
            }
            for (int[] edge : edges) {
                nodes.get(edge[0]).addConnection(nodes.get(edge[1]));
            }
        }

        boolean leadsToDestination(int source, int destination) {
            Deque<Node> stack = new ArrayDeque<>();
            stack.push(nodes.get(source));

            while (!stack.isEmpty()) {
                Node current = stack.pop();
                if (current.isPassed()) {
                    current.markParentsPassed();
                    continue;
                }
                current.markVisited();

                Set<Node> connections = current.getConnections();
                if (connections.isEmpty() && current.getId() != destination) {
                    return false;
                } else if (connections.isEmpty()) {
                    current.markParentsPassed();
                }

                for (Node node : connections) {
                    if (node.isVisited()) {
                        return false;
                    }
                    node.setParent(current);
                    stack.push(node);
                }
            }

            return true;
        }
    }

    static class Node {
        private final int id;
        private Node parent;
        private final Set<Node> connections = new HashSet<>();
        private boolean isVisited;
        private boolean isPassed;

        Node(int id) {
            this.id = id;
        }

        int getId() {
            return id;
        }

        Node getParent() {
            return parent;
        }

        void setParent(Node parent) {
            this.parent = parent;
        }

        Set<Node> getConnections() {
            return connections;
        }

        void addConnection(Node node) {
            connections.add(node);
        }

        boolean isVisited() {
            return isVisited;
        }

        boolean isPassed() {
            return isPassed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return id == node.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        void markVisited() {
            isVisited = true;
        }

        void markPassed() {
            isVisited = false;
            isPassed = true;
        }

        void markParentsPassed() {
            Node parent = this;
            do {
                parent.markPassed();
                parent = parent.getParent();
            } while (parent != null && !parent.isPassed());
        }
    }
}
