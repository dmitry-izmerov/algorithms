package ru.demi.algorithms.leetcode.graphs.shortest_path;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.shortest_path.NetworkDelayByDijkstra.networkDelayTime;

class NetworkDelayByDijkstraTest {

    @Test
    void shouldReturn1If2Nodes() {
        var delay = networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1);
        assertThat(delay).isEqualTo(1);
    }

    @Test
    void shouldReturnMinus1If2Nodes() {
        var delay = networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2);
        assertThat(delay).isEqualTo(-1);
    }

    @Test
    void shouldReturn2If4Nodes() {
        var delay = networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        assertThat(delay).isEqualTo(2);
    }

    @Test
    void shouldReturn3If4Nodes() {
        var delay = networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1);
        assertThat(delay).isEqualTo(3);
    }

    @Test
    void shouldReturn5If5Nodes() {
        var delay = networkDelayTime(new int[][]{
            {3, 5, 78},
            {2, 1, 1},
            {1, 3, 0},
            {4, 3, 59},
            {5, 3, 85},
            {5, 2, 22},
            {2, 4, 23},
            {1, 4, 43},
            {4, 5, 75},
            {5, 1, 15},
            {1, 5, 91},
            {4, 1, 16},
            {3, 2, 98},
            {3, 4, 22},
            {5, 4, 31},
            {1, 2, 0},
            {2, 5, 4},
            {4, 2, 51},
            {3, 1, 36},
            {2, 3, 59}
        }, 5, 5);
        assertThat(delay).isEqualTo(31);
    }

}