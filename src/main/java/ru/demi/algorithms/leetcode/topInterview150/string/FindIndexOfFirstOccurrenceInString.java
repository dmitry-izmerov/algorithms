package ru.demi.algorithms.leetcode.topInterview150.string;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 * Constraints:
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class FindIndexOfFirstOccurrenceInString {

    // using Knuth–Morris–Pratt Algorithm
    public int strStr(String haystack, String needle) {
        var nl = needle.length();
        var hl = haystack.length();
        if (nl > hl) return -1;

        var lps = new int[nl];
        var prev = 0;
        for (var i = 1; i < nl;) {
            if (needle.charAt(prev) == needle.charAt(i)) {
                prev++;
                lps[i] = prev;
                i += 1;
            } else {
                if (prev == 0) {
                    lps[i] = 0;
                    i += 1;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }

        var np = 0;
        for (var hp = 0; hp < hl;) {
            if (haystack.charAt(hp) == needle.charAt(np)) {
                np++;
                hp++;
                if (np == nl) {
                    return hp - nl;
                }
            } else {
                if (np == 0) {
                    hp++;
                } else {
                    np = lps[np - 1];
                }
            }
        }
        return -1;
    }
}
