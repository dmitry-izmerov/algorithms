package ru.demi.algorithms.leetcode.graphs.disjoint_set;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AllFriendsEarliestTest {

    @Test
    void earliestAcq() {
        var expected = 20190301;
        int[][] logs = new int[][]{
            {20190101, 0, 1},
            {20190104, 3, 4},
            {20190107, 2, 3},
            {20190211, 1, 5},
            {20190224, 2, 4},
            {expected, 0, 3},
            {20190312, 1, 2},
            {20190322, 4, 5}
        };

        var actual = AllFriendsEarliest.earliestAcq(logs, 6);

        assertThat(actual).isEqualTo(expected);
    }
}