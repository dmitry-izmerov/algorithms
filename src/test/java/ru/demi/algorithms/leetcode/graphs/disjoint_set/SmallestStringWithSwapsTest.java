package ru.demi.algorithms.leetcode.graphs.disjoint_set;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestStringWithSwapsTest {

    @Test
    void swapTwoUnrelatedPairs() {
        var swaps = new SmallestStringWithSwaps();
        var actual = swaps.calculate("dcab", List.of(List.of(0, 3), List.of(1, 2)));
        assertThat(actual).isEqualTo("bacd");
    }

    @Test
    void swapTwoRelatedPairs() {
        var swaps = new SmallestStringWithSwaps();
        var actual = swaps.calculate("cba", List.of(List.of(0, 1), List.of(1, 2)));
        assertThat(actual).isEqualTo("abc");
    }

    @Test
    void swapThreeRelatedPairs() {
        var swaps = new SmallestStringWithSwaps();
        var actual = swaps.calculate("dcab", List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2)));
        assertThat(actual).isEqualTo("abcd");
    }
}