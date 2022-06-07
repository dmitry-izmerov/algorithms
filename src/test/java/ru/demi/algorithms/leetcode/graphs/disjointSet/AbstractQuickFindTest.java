package ru.demi.algorithms.leetcode.graphs.disjointSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class AbstractQuickFindTest {

    private DisjointSet disjointSet;

    abstract DisjointSet getDisjointSet(int length);

    @BeforeEach
    void beforeEach() {
        disjointSet = createDisjointSet();
    }

    @Test
    void shouldReturnRootIndex() {
        var actual = disjointSet.findRoot(1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void shouldUnionVertices() {
        assertThat(disjointSet.findRoot(0)).isEqualTo(0);
        assertThat(disjointSet.findRoot(1)).isEqualTo(0);
        assertThat(disjointSet.findRoot(3)).isEqualTo(0);

        assertThat(disjointSet.findRoot(2)).isEqualTo(2);
        assertThat(disjointSet.findRoot(4)).isEqualTo(4);
        assertThat(disjointSet.findRoot(6)).isEqualTo(6);

        assertThat(disjointSet.findRoot(5)).isEqualTo(5);
        assertThat(disjointSet.findRoot(7)).isEqualTo(5);
        assertThat(disjointSet.findRoot(8)).isEqualTo(5);
    }

    @Test
    void shouldReturnTrueIfConnected() {
        assertThat(disjointSet.isConnected(0, 3)).isTrue();
    }

    @Test
    void shouldReturnFalseIfNotConnected() {
        assertThat(disjointSet.isConnected(1, 5)).isFalse();
    }

    private DisjointSet createDisjointSet() {
        var disjointSet = getDisjointSet(9);
        disjointSet.union(0, 1);
        disjointSet.union(1, 3);

        disjointSet.union(5, 7);
        disjointSet.union(7, 8);

        return disjointSet;
    }
}
