package ru.demi.algorithms.leetcode.topInterview150.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        this.res = new LinkedList<List<Integer>>();
        this.n = n;
        this.k = k;
        add(1, new LinkedList<>());
        return this.res;
    }

    private List<List<Integer>> res;
    private int n;
    private int k;

    void add(int start, LinkedList<Integer> list) {
        if (list.size() == k) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (var i = start; i <= n; i++) {
            list.add(i);
            add(i + 1, list);
            list.removeLast();
        }
    }
}
