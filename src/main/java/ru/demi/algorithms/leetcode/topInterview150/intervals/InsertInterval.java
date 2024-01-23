package ru.demi.algorithms.leetcode.topInterview150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Constraints:
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^5
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 10^5
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        var merged = insertInterval(intervals, newInterval);
        var res = new LinkedList<int[]>();
        for (var i = 0; i < merged.size(); i++) {
            var curInterval = new int[]{ merged.get(i)[0], merged.get(i)[1] };
            while (i < merged.size() && isOverlapped(curInterval, merged.get(i))) {
                curInterval = mergeIntervals(curInterval, merged.get(i));
                i++;
            }
            i--;
            res.add(curInterval);
        }
        return res.toArray(int[][]::new);
    }

    List<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        var list = new ArrayList<>(Arrays.asList(intervals));
        var inserted = false;

        for (var i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[0]) {
                inserted = true;
                list.add(i, newInterval);
                break;
            }
        }

        if (!inserted) {
            list.add(newInterval);
        }

        return list;
    }

    boolean isOverlapped(int[] a, int[] b) {
        return Math.min(a[1], b[1]) - Math.max(a[0], b[0]) >= 0;
    }

    int[] mergeIntervals(int[] a, int[] b) {
        return new int[]{ Math.min(a[0], b[0]), Math.max(a[1], b[1]) };
    }
}
