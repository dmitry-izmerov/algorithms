package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {

    MergeSortedArray instance = new MergeSortedArray();

    @Test
    void merge1And1SizedArrays() {
        int[] ar1 = new int[] {2,0};
        int[] ar2 = new int[] {1};

        instance.merge(ar1, 1, ar2, 1);
        assertArrayEquals(new int[]{1,2}, ar1);
    }

    @Test
    void merge3And3SizedArrays() {
        int[] ar1 = new int[] {1,2,3,0,0,0};
        int[] ar2 = new int[] {2,5,6};

        instance.merge(ar1, 3, ar2, 3);
        assertArrayEquals(new int[]{1,2,2,3,5,6}, ar1);
    }

    @Test
    void merge1And5SizedArrays() {
        int[] ar1 = new int[] {4,0,0,0,0,0};
        int[] ar2 = new int[] {1,2,3,5,6};

        instance.merge(ar1, 1, ar2, 5);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, ar1);
    }

    @Test
    void merge5And1SizedArrays() {
        int[] ar1 = new int[] {1,2,4,5,6,0};
        int[] ar2 = new int[] {3};

        instance.merge(ar1, 5, ar2, 1);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, ar1);
    }

    @Test
    void merge1And0SizedArrays() {
        int[] ar1 = new int[] {1};
        int[] ar2 = new int[] {};

        instance.merge(ar1, 1, ar2, 0);
        assertArrayEquals(new int[]{1}, ar1);
    }

    @Test
    void merge0And1SizedArrays() {
        int[] ar1 = new int[] {0};
        int[] ar2 = new int[] {1};

        instance.merge(ar1, 0, ar2, 1);
        assertArrayEquals(new int[]{1}, ar1);
    }
}
