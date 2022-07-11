package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstBadVersionTest {

    @Test
    void shouldReturnTrueForFirst() {
        FirstBadVersion instance = new FirstBadVersion(1);
        int version = instance.firstBadVersion(1);
        assertEquals(1, version);
    }

    @Test
    void shouldReturnTrueForThird() {
        FirstBadVersion instance = new FirstBadVersion(3);
        int version = instance.firstBadVersion(3);
        assertEquals(3, version);
    }

    @Test
    void shouldReturnTrueForFourth() {
        FirstBadVersion instance = new FirstBadVersion(4);
        int version = instance.firstBadVersion(5);
        assertEquals(4, version);
    }
}
