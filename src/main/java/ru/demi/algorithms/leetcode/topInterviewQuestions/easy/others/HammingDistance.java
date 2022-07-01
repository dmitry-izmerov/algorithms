package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, return the Hamming distance between them.
 *
 * Constraints:
 * - 0 <= x, y <= 231 - 1
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return getBitsNum(x ^ y);
    }

    private int getBitsNum(int num) {
        int res = 0;
        int checker = 1;
        for (var i = 1; i <= 32; ++i) {
            if ((num & checker) != 0) {
                ++res;
            }
            checker = checker << 1;
        }
        return res;
    }
}
