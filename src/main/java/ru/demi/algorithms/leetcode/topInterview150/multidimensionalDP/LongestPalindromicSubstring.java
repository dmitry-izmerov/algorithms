package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {
    record Range(int i, int j) {}

    public String longestPalindrome(String s) {
        var n = s.length();
        var dp = new boolean[n][n];
        var res = new Range(0, 0);

        for (var i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (var i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                res = new Range(i, i + 1);
            }
        }

        for (var diff = 2; diff < n; diff++) {
            for (var i = 0; i < n - diff; i++) {
                var j = i + diff;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res = new Range(i, j);
                }
            }
        }

        return s.substring(res.i, res.j + 1);
    }
}
