package ru.demi.algorithms.leetcode.yandex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineReflectionTest {

    @Test
    void shouldBeReflectedFor4PositivePoints1() {
        boolean reflected = LineReflection.isReflected(new int[][]{{1, 2}, {1, 4}, {2, 2}, {2, 4}});
        assertThat(reflected).isTrue();
    }

    @Test
    void shouldBeReflectedFor3PointsWithMiddleInZero() {
        boolean reflected = LineReflection.isReflected(new int[][]{{1, 1}, {0, 0}, {-1, 1}});
        assertThat(reflected).isTrue();
    }

    @Test
    void shouldBeReflectedFor4PositivePoints2() {
        boolean reflected = LineReflection.isReflected(new int[][]{{1, 2}, {2, 2}, {3, 2}, {4, 2}});
        assertThat(reflected).isTrue();
    }

    @Test
    void shouldBeReflectedFor2Points() {
        boolean reflected = LineReflection.isReflected(new int[][]{{0,0}, {0,-1}});
        assertThat(reflected).isTrue();
    }

}