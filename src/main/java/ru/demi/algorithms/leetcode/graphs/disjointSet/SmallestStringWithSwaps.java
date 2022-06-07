package ru.demi.algorithms.leetcode.graphs.disjointSet;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestStringWithSwaps {

    public String calculate(String s, List<List<Integer>> pairs) {
        UnionFind unionFind = new UnionFind(s, pairs);
        var groups = unionFind.getGroups();
        List<CharAtIndex> chars = convert(groups);

        StringBuilder res = new StringBuilder(s);
        for (CharAtIndex c : chars) {
            res.setCharAt(c.getIndex(), c.getCharacter());
        }
        return res.toString();
    }

    List<CharAtIndex> convert(List<List<CharAtIndex>> groups) {
        return groups.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    static class CharAtIndex {
        private final int index;
        private final char character;

        CharAtIndex(int n, char c) {
            index = n;
            character = c;
        }

        int getIndex() {
            return index;
        }

        char getCharacter() {
            return character;
        }
    }

    static class UnionFind {
        private final int[] parents;
        private final int[] ranks;
        private final String str;

        UnionFind(String str, List<List<Integer>> pairs) {
            this.str = str;
            int size = str.length();
            parents = new int[size];
            ranks = new int[size];
            for (int i = 0; i < size; ++i) {
                parents[i] = i;
                ranks[i] = 1;
            }
            build(pairs);
        }

        List<List<CharAtIndex>> getGroups() {
            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int i = 0; i < str.length(); ++i) {
                int root = parents[i];
                int index = i;
                groups.compute(root, (k, list) -> {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(index);
                    return list;
                });
            }

            return groups.values().stream().filter(list -> list.size() > 1)
                .map(indexes -> {
                    indexes.sort(null);
                    var chars = indexes.stream().map(str::charAt).sorted().collect(Collectors.toList());
                    return IntStream.range(0, indexes.size())
                        .mapToObj(i -> new CharAtIndex(indexes.get(i), chars.get(i)))
                        .collect(Collectors.toList());
                })
                .collect(Collectors.toList());
        }

        private void build(List<List<Integer>> pairs) {
            for(List<Integer> pair : pairs) {
                union(pair.get(0), pair.get(1));
            }
        }

        private void union(int vertA, int vertB) {
            int rootA = findRoot(vertA);
            int rootB = findRoot(vertB);
            if (rootA == rootB) {
                return;
            }
            if (ranks[rootA] >= ranks[rootB]) {
                parents[rootB] = rootA;
                ranks[rootA] += ranks[rootB];
                markJoined(rootA, rootB);
            } else {
                parents[rootA] = rootB;
                ranks[rootB] += ranks[rootA];
                markJoined(rootB, rootA);
            }
        }

        private int findRoot(int vertex) {
            int root = vertex;
            while (parents[root] != root) {
                root = parents[root];
            }
            return root;
        }

        private void markJoined(int mainRoot, int joined) {
            for (int i = 0; i < parents.length; i++) {
                if (parents[i] == joined) {
                    parents[i] = mainRoot;
                }
            }
        }
    }
}
