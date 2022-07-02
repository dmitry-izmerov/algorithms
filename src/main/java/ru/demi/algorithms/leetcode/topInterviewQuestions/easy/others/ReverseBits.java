package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input
 * and output will be given as a signed integer type. They should not affect your implementation,
 * as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above,
 * the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 * Constraints:
 * - The input must be a binary string of length 32
 */
public class ReverseBits {

    public int reverseBits(int n) {
        var binary = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        var reversed = new StringBuilder(binary).reverse().toString();
        return Integer.parseUnsignedInt(reversed, 2);
    }

    public int reverseBitsUsingStdLib(int n) {
        return Integer.reverse(n);
    }
}
