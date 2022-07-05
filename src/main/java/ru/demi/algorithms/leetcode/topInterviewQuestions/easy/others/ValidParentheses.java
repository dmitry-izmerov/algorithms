package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Constraints:
 * - 1 <= s.length <= 10^4
 * - s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    private final Set<Character> open = Set.of('(', '[', '{');
    private final Map<Character, Character> pairs = Map.of(')', '(',  ']','[', '}', '{');

    public boolean isValid(String s) {
        if (s.isEmpty()){
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        var stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (open.contains(c)) {
                stack.push(c);
            } else if (pairs.get(c).equals(stack.peek())) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
