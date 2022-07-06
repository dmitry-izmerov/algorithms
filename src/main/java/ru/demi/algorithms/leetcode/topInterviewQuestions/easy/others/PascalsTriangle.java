package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above.
 * Constraints:
 * - 1 <= numRows <= 30
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            result.add(new ArrayList<>(Collections.nCopies(i, 1)));
        }

        for (int i = 1; i < numRows - 1; i++) {
            var current = result.get(i);
            for (int j = 0; j < current.size() - 1; j++) {
                var next = result.get(i + 1);
                next.set(j + 1, current.get(j) + current.get(j + 1));
            }
        }

        return result;
    }
}
