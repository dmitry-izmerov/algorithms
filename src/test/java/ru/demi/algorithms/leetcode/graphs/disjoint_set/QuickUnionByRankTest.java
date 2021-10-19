package ru.demi.algorithms.leetcode.graphs.disjoint_set;

class QuickUnionByRankTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnionByRank(length);
    }
}