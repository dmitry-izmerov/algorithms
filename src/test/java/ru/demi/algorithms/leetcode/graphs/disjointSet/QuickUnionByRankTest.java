package ru.demi.algorithms.leetcode.graphs.disjointSet;

class QuickUnionByRankTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnionByRank(length);
    }
}
