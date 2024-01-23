package ru.demi.algorithms.leetcode.topInterview150.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(ar -> ar[0]));
        var count = intervals.length;
        for (var i = 0; i + 1 < intervals.length; i++) {
            var cur = intervals[i];
            var next = intervals[i + 1];

            if (cur[1] >= next[0]) {
                next[0] = Math.min(cur[0], next[0]);
                next[1] = Math.max(cur[1], next[1]);
                intervals[i] = null;
                count--;
            }
        }

        var res = new int[count][2];
        var i = 0;
        for (var interval : intervals) {
            if (interval != null) {
                res[i++] = interval;
            }
        }
        return res;
    }
}
