package ru.demi.algorithms.problems;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void shouldMergeIntervalsIfPartialIntersection() {
        var merged = MergeIntervals.merge(new int[][]{{1, 5}, {3, 8}});

        assertThat(merged).isEqualTo(new int[][]{{1, 8}});
    }

    @Test
    void shouldMergeIntervalsIfFirstIsLessThanSecond() {
        var merged = MergeIntervals.merge(new int[][]{{1, 4}, {0, 4}});

        assertThat(merged).isEqualTo(new int[][]{{0, 4}});
    }

    @Test
    void shouldMergeIntervalsIfFirstContainsSecond() {
        var merged = MergeIntervals.merge(new int[][]{{1, 5}, {2, 4}});

        assertThat(merged).isEqualTo(new int[][]{{1, 5}});
    }

    @Test
    void shouldMergeIntervalsIfSecondContainsFirst() {
        var merged = MergeIntervals.merge(new int[][]{{1, 2}, {1, 4}});

        assertThat(merged).isEqualTo(new int[][]{{1, 4}});
    }

    @Test
    void shouldMergeIntervalsIfFirstEndEqualsSecondStart() {
        var merged = MergeIntervals.merge(new int[][]{{1, 4}, {4, 6}});

        assertThat(merged).isEqualTo(new int[][]{{1, 6}});
    }
}