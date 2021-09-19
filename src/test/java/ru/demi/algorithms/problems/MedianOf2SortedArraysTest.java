package ru.demi.algorithms.problems;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.problems.MedianOf2SortedArrays.findMedianSortedArrays;

class MedianOf2SortedArraysTest {

    @Test
    void shouldFindMedianOfSortedArrays() {
        double actual = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});

        assertThat(actual).isEqualTo(2.5d);
    }
}