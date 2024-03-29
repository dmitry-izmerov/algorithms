package ru.demi.algorithms.leetcode.topInterview150.slidingWindow;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        var left = 0;
        var map = new HashMap<Character, Integer>();
        var maxLen = 0;
        for (var right = 0; right < s.length(); right++) {
            var c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c));
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(c, right + 1);
        }
        return maxLen;
    }
}
