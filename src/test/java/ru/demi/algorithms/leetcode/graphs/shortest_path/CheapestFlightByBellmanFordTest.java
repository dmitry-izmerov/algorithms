package ru.demi.algorithms.leetcode.graphs.shortest_path;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.shortest_path.CheapestFlightByBellmanFord.findCheapestPrice;

class CheapestFlightByBellmanFordTest {

    @Test
    void shouldFindPriceForZeroStop() {
        var cheapestPrice = findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0);
        assertThat(cheapestPrice).isEqualTo(500);
    }

    @Test
    void shouldFindPriceForOneStop() {
        var cheapestPrice = findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        assertThat(cheapestPrice).isEqualTo(200);
    }

    @Test
    void shouldFindPriceForTwoStop() {
        var cheapestPrice = findCheapestPrice(5, new int[][]{
            {0, 1, 100},
            {0, 2, 300},
            {0, 3, 200},
            {3, 2, 500},
            {1, 4, 100},
            {4, 2, 50},
            {3, 4, 150}
        }, 0, 2, 2);
        assertThat(cheapestPrice).isEqualTo(250);
    }
}