package ru.demi.algorithms.leetcode.topInterview150.stack;

import java.util.LinkedList;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    Map<Character, Character> map = Map.of(')', '(', '}', '{',  ']', '[');

    public boolean isValid(String s) {
        var stack = new LinkedList<Character>();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
