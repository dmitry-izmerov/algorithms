package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.HashMap;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 *
 * Constraints:
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        var directMap = new HashMap<Character, String>();
        var reversedMap = new HashMap<String, Character>();
        var prev = 0;
        var wordCount = 0;
        for (var i = 0; i < s.length(); i++) {
            if (wordCount >= pattern.length()) {
                return false;
            }
            var c = s.charAt(i);
            if (i == s.length() - 1) {
                c = ' ';
                i++;
            }
            if (Character.isSpaceChar(c)) {
                var word = s.substring(prev, i);
                var patternChar = pattern.charAt(wordCount);
                if (directMap.containsKey(patternChar) && !directMap.get(patternChar).equals(word)) {
                    return false;
                }
                if (reversedMap.containsKey(word) && !reversedMap.get(word).equals(patternChar)) {
                    return false;
                }
                if (i == s.length() && pattern.length() - 1 != wordCount) {
                    return false;
                }
                directMap.put(patternChar, word);
                reversedMap.put(word, patternChar);
                wordCount++;
                prev = i + 1;
            }
        }

        return true;
    }
}
