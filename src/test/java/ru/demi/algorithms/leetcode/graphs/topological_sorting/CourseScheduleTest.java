package ru.demi.algorithms.leetcode.graphs.topological_sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.demi.algorithms.leetcode.graphs.topological_sorting.CourseSchedule.findOrder;

class CourseScheduleTest {

    @Test
    void shouldReturnEmptyArrayIfNoConnections() {
        int[] actual = findOrder(8, new int[][]{{1, 0}, {2, 6}, {1, 7}, {5, 1}, {6, 4}, {7, 0}, {0, 5}});
        assertThat(actual).isEqualTo(new int[]{});
    }

    @Test
    void shouldReturnCoursesIf0Courses() {
        int[] actual = findOrder(3, new int[][]{});
        assertThat(actual).isEqualTo(new int[]{0, 1, 2});
    }

    @Test
    void shouldReturnCoursesIf2Courses() {
        int[] actual = findOrder(3, new int[][]{{1, 0}});
        assertThat(actual).isEqualTo(new int[]{0, 2, 1});
    }

    @Test
    void shouldReturnCoursesIf3Courses() {
        int[] actual = findOrder(3, new int[][]{{2, 0}, {2, 1}});
        assertThat(actual).isEqualTo(new int[]{0, 1, 2});
    }

    @Test
    void shouldReturnCoursesIf4Courses() {
        int[] actual = findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        assertThat(actual).isEqualTo(new int[]{0, 1, 2, 3});
    }
}
