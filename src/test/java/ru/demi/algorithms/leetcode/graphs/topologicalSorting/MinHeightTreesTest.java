package ru.demi.algorithms.leetcode.graphs.topologicalSorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ru.demi.algorithms.leetcode.graphs.topologicalSorting.MinHeightTrees.findMinHeightRoots;

class MinHeightTreesTest {

    @Test
    void shouldReturn1RootIf1NodesWithoutEdges() {
        List<Integer> minHeightRoots = findMinHeightRoots(1, new int[][]{});
        Assertions.assertThat(minHeightRoots).isEqualTo(List.of(0));
    }

    @Test
    void shouldReturn1RootIf4Nodes() {
        List<Integer> minHeightRoots = findMinHeightRoots(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
        Assertions.assertThat(minHeightRoots).isEqualTo(List.of(1));
    }

    @Test
    void shouldReturn2RootsIf6Nodes() {
        List<Integer> minHeightRoots = findMinHeightRoots(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}});
        Assertions.assertThat(minHeightRoots).isEqualTo(List.of(3, 4));
    }
}
