package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        var counts = new HashMap<Character, Integer>();
        for (var i = 0; i < s.length(); i++) {
            var sc = s.charAt(i);
            var tc = t.charAt(i);
            var count = counts.getOrDefault(sc, 0);
            counts.put(sc, count + 1);
            count = counts.getOrDefault(tc, 0);
            counts.put(tc, count - 1);
        }

        for (var v : counts.values()) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }
}
