package ru.demi.algorithms.leetcode.topInterview150.multidimensionalDP;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class EditDistance {
    String word1, word2;
    Map<String, Integer> cache;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        cache = new HashMap<>();
        return dp(word1.length(), word2.length());
    }

    int dp(int i, int j) {
        var key = i + ":" + j;
        if (cache.containsKey(key)) return cache.get(key);
        if (i == 0) return j;
        if (j == 0) return i;

        var res = 0;
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            res = dp(i - 1, j - 1);
        } else {
            var insertion = dp(i, j - 1);
            var delete = dp(i - 1, j);
            var replace = dp(i - 1, j - 1);
            res = 1 + Math.min(insertion, Math.min(delete, replace));
        }
        cache.put(key, res);
        return res;
    }
}
