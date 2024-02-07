package ru.demi.algorithms.leetcode.topInterview150.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 *
 * Constraints:
 * 1 <= n <= 8
 */
public class GenerateParentheses {
    int n;
    List<String> res;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new LinkedList<>();
        generate(0, 0, new StringBuilder());
        return res;
    }

    void generate(int open, int closed, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append('(');
            generate(open + 1, closed, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (open > closed) {
            sb.append(')');
            generate(open, closed + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
