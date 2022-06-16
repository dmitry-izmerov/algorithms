package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.math;

public class PowerOfThree {

    public static boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        var val = Math.log10(n) / Math.log10(3);
        return val % 1 == 0;
    }
}
