package ru.demi.algorithms.graphs.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DFSValidPathTest {

    @Test
    void shouldReturnTrueIfPathExists() {
        var instance = new DFSValidPath();
        var actual = instance.check(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void shouldReturnFalseIfPathNotExists() {
        var instance = new DFSValidPath();
        var actual = instance.check(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5);
        Assertions.assertThat(actual).isFalse();
    }
}