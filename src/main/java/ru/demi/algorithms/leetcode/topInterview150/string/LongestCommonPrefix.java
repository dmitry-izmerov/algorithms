package ru.demi.algorithms.leetcode.topInterview150.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        var prefix = new StringBuilder();
        for (var i = 0; i < strs[0].length(); i++) {
            var commonChar = strs[0].charAt(i);
            for (var s : strs) {
                var c = s.charAt(i);
                if (c != commonChar) {
                    return prefix.toString();
                }
            }
            prefix.append(commonChar);
        }
        return prefix.toString();
    }
}
