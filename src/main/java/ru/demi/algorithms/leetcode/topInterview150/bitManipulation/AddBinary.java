package ru.demi.algorithms.leetcode.topInterview150.bitManipulation;

import java.math.BigInteger;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        var aBin = new BigInteger(a, 2);
        var bBin = new BigInteger(b, 2);
        var res = aBin.add(bBin);
        return res.toString(2);
    }
}
