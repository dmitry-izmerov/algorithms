package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.HashMap;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
 * magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        var symbols = new HashMap<Character, Integer>();
        for (var c : magazine.toCharArray()) {
            var count = symbols.getOrDefault(c, 0);
            symbols.put(c, count + 1);
        }

        for (var c : ransomNote.toCharArray()) {
            var count = symbols.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            }
            symbols.put(c, count - 1);
        }

        return true;
    }
}
