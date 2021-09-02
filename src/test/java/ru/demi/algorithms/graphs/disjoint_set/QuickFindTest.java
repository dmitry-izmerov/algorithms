package ru.demi.algorithms.graphs.disjoint_set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickFindTest {

    @Test
    void shouldReturnRootIndex() {
        var set = createDisjointSet();

        var actual = set.findRoot(1);

        assertThat(actual).isEqualTo(0);
    }

    @Test
    void shouldUnionVertices() {
        var set = createDisjointSet();

        assertThat(set.findRoot(0)).isEqualTo(0);
        assertThat(set.findRoot(1)).isEqualTo(0);
        assertThat(set.findRoot(3)).isEqualTo(0);

        assertThat(set.findRoot(2)).isEqualTo(2);
        assertThat(set.findRoot(4)).isEqualTo(4);
        assertThat(set.findRoot(6)).isEqualTo(6);

        assertThat(set.findRoot(5)).isEqualTo(5);
        assertThat(set.findRoot(7)).isEqualTo(5);
        assertThat(set.findRoot(8)).isEqualTo(5);
    }

    @Test
    void shouldReturnTrueIfConnected() {
        var set = createDisjointSet();

        assertThat(set.isConnected(0, 3)).isTrue();
    }

    @Test
    void shouldReturnFalseIfNotConnected() {
        var set = createDisjointSet();

        assertThat(set.isConnected(1, 5)).isFalse();
    }

    private QuickFind createDisjointSet() {
        var quickFind = new QuickFind(9);
        quickFind.union(0, 1);
        quickFind.union(1, 3);

        quickFind.union(5, 7);
        quickFind.union(7, 8);

        return quickFind;
    }
}