package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minLength = Arrays.stream(strs).min(Comparator.comparing(String::length)).map(String::length).orElse(0);
        if (minLength == 0) {
            return "";
        }

        int i = 0;
        outer: for (; i < minLength; i++) {
            var baseChar = strs[0].charAt(i);
            for (String str : strs) {
                var otherChar = str.charAt(i);
                if (baseChar != otherChar) {
                    break outer;
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
