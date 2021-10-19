package ru.demi.algorithms.leetcode.graphs.shortest_path;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.shortest_path.PathWithMinimumTotalEffort.getMinimumEffortPath;

class PathWithMinimumTotalEffortTest {

    @Test
    void shouldReturn9IfMatrix1x8() {
        var actual = getMinimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}});
        assertThat(actual).isEqualTo(28);
    }

    @Test
    void shouldReturn2IfMatrix3x3() {
        var actual = getMinimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}});
        assertThat(actual).isEqualTo(4);
    }

    @Test
    void shouldReturn1IfMatrix3x3() {
        var actual = getMinimumEffortPath(new int[][]{{1, 1, 1}, {3, 8, 2}, {5, 3, 1}});
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void shouldReturn0IfMatrix5x5() {
        var actual = getMinimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}});
        assertThat(actual).isEqualTo(0);
    }
}