package ru.demi.algorithms.leetcode.graphs.disjoint_set;

class QuickFindTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickFind(length);
    }
}
