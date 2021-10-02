package ru.demi.algorithms.graphs.bfs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.graphs.bfs.FindPath.isValidPath;

class FindPathTest {

    @Test
    void shouldReturnTrueIfPathValid() {
        var actual = isValidPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5);
        assertThat(actual).isTrue();
    }
}