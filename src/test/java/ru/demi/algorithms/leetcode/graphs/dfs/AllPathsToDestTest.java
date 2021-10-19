package ru.demi.algorithms.leetcode.graphs.dfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.dfs.AllPathsToDest.leadsToDestination;

class AllPathsToDestTest {

    @Test
    void shouldReturnFalseIfHas2Paths() {
        var actual = leadsToDestination(3, new int[][]{{0, 1}, {0, 2}}, 0, 2);
        assertThat(actual).isFalse();
    }

    @Test
    void shouldReturnFalseIfContainsLoop() {
        var actual = leadsToDestination(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 1}}, 0, 3);
        assertThat(actual).isFalse();
    }

    @Test
    void shouldReturnFalseIfContainsSelfLoop() {
        var actual = leadsToDestination(3, new int[][]{{0, 1}, {1, 1}, {1, 2}}, 0, 2);
        assertThat(actual).isFalse();
    }

    @Test
    void shouldReturnTrueIfContains2PathsLeadToDest() {
        var actual = leadsToDestination(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}, 0, 3);
        assertThat(actual).isTrue();
    }

    @Test
    void shouldReturnTrueIfContainsMultiplePathsLeadToDest() {
        var actual = leadsToDestination(5, new int[][]{{0,1},{0,2},{0,3},{0,3},{1,2},{1,3},{1,4},{2,3},{2,4},{3,4}}, 0, 4);
        assertThat(actual).isTrue();
    }
}
