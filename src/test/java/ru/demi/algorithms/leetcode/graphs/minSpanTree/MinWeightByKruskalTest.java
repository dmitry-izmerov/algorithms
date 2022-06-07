package ru.demi.algorithms.leetcode.graphs.minSpanTree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.minSpanTree.MinWeightByKruskal.minWeightConnectPoints;

class MinWeightByKruskalTest {

    @Test
    void shouldReturnMinWeightIf2Points() {
        var minWeight = minWeightConnectPoints(new int[][]{{-1000000,-1000000},{1000000,1000000}});
        assertThat(minWeight).isEqualTo(4000000);
    }

    @Test
    void shouldReturnMinWeightIf3Points() {
        var minWeight = minWeightConnectPoints(new int[][]{{3,12},{-2,5},{-4,1}});
        assertThat(minWeight).isEqualTo(18);
    }

    @Test
    void shouldReturnMinWeightIf5Points() {
        var minWeight = minWeightConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});
        assertThat(minWeight).isEqualTo(20);
    }
}
