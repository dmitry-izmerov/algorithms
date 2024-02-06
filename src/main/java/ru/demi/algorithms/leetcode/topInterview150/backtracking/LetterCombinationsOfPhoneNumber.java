package ru.demi.algorithms.leetcode.topInterview150.backtracking;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class LetterCombinationsOfPhoneNumber {
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) return Collections.emptyList();

        res = new LinkedList<>();
        combine(digits, 0, new StringBuilder());
        return res;
    }

    void combine(String digits, int i, StringBuilder cur) {
        if (cur.length() == digits.length()) {
            res.add(cur.toString());
            return;
        }
        var c = digits.charAt(i);
        var word = map.get(c);
        for (var ch : word.toCharArray()) {
            cur.append(ch);
            combine(digits, i + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
