package ru.demi.algorithms.leetcode.graphs.disjointSet;

class QuickUnionTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnion(length);
    }
}
