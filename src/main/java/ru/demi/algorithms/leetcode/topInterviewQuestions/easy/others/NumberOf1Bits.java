package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type.
 * In this case, the input will be given as a signed integer type.
 * It should not affect your implementation, as the integer's internal binary representation is the same,
 * whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3, the input represents the signed integer. -3.
 *
 * Constraints:
 * The input must be a binary string of length 32.
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int num) {
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
