package ru.demi.algorithms.graphs.disjoint_set;

class QuickUnionWithPathCompressionTest extends AbstractQuickFindTest {

    @Override
    DisjointSet getDisjointSet(int length) {
        return new QuickUnionWithPathCompression(length);
    }
}