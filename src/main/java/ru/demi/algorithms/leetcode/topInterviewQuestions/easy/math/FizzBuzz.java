package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        var result = new ArrayList<String>();
        for (var i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.isEmpty()) {
                sb.append(i);
            }
            result.add(sb.toString());

        }
        return result;
    }
}
