package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    @Test
    void shouldReturnTrueForFirst() {
        FirstBadVersion instance = new FirstBadVersion(Map.of(1, true));
        int version = instance.firstBadVersion(1);
        assertEquals(1, version);
    }

    @Test
    void shouldReturnTrueForThird() {
        FirstBadVersion instance = new FirstBadVersion(Map.of(1, false, 2, false, 3, true));
        int version = instance.firstBadVersion(3);
        assertEquals(3, version);
    }

    @Test
    void shouldReturnTrueForFourth() {
        FirstBadVersion instance = new FirstBadVersion(Map.of(1, false, 2, false, 3, false, 4, true, 5, true));
        int version = instance.firstBadVersion(5);
        assertEquals(4, version);
    }
}
