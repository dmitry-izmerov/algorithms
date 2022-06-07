package ru.demi.algorithms.leetcode.graphs.disjointSet;

class QuickUnionWithPathCompressionTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnionWithPathCompression(length);
    }
}
