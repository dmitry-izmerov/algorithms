package ru.demi.algorithms.leetcode.graphs.disjointSet;

class QuickFindTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickFind(length);
    }
}
