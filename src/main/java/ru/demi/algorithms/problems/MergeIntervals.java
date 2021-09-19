package ru.demi.algorithms.problems;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int merged = 0;
        for (int i = 0; i < intervals.length - 1; ++i) {

            boolean inAnyConditions = false;
            if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][0] < intervals[i + 1][0]) {
                intervals[i + 1][0] = intervals[i][0];
                inAnyConditions = true;
            }

            if (intervals[i + 1][0] >= intervals[i][0] && intervals[i + 1][1] <= intervals[i][1]) {
                intervals[i + 1][0] = intervals[i][0];
                intervals[i + 1][1] = intervals[i][1];
                inAnyConditions = true;
            }

            if (intervals[i][0] >= intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][1]) {
                inAnyConditions = true;
            }

            if (inAnyConditions) {
                intervals[i] = null;
                ++merged;
            }
        }

        int[][] result = new int[intervals.length - merged][2];
        for (int i = 0, j = 0; i < intervals.length; ++i) {
            if (intervals[i] != null) {
                result[j] = intervals[i];
                ++j;
            }
        }
        return result;
    }
}
