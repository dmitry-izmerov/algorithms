package ru.demi.algorithms.leetcode.graphs.disjoint_set;

class QuickUnionTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnion(length);
    }
}