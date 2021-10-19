package ru.demi.algorithms.leetcode.graphs.topological_sorting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.demi.algorithms.leetcode.graphs.topological_sorting.ParallelCourses.getMinimumSemesters;

class ParallelCoursesTest {

    @Test
    void shouldReturn2If3NodesAnd2Relations() {
        int actual = getMinimumSemesters(3, new int[][]{{1, 3}, {2, 3}});
        Assertions.assertThat(actual).isEqualTo(2);
    }

    @Test
    void shouldReturnNegativeAnswerIf3NodesContainCycle() {
        int actual = getMinimumSemesters(3, new int[][]{{1,2},{2,3},{3,1}});
        Assertions.assertThat(actual).isEqualTo(-1);
    }

    @Test
    void shouldReturnNegativeAnswerIf4NodesContainCycle() {
        int actual = getMinimumSemesters(4, new int[][]{{1,2},{2,3},{3,4},{4,2}});
        Assertions.assertThat(actual).isEqualTo(-1);
    }
}
