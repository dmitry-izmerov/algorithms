package ru.demi.algorithms.leetcode.topInterview150.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var groups = new HashMap<String, List<String>>();
        for (var s : strs) {
            var ar = s.toCharArray();
            Arrays.sort(ar);
            var key = new String(ar);
            var l = groups.getOrDefault(key, new ArrayList<>());
            l.add(s);
            groups.put(key, l);
        }

        return new ArrayList<>(groups.values());
    }
}
