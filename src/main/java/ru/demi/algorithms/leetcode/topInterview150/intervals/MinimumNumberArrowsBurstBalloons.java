package ru.demi.algorithms.leetcode.topInterview150.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented
 * as a 2D integer array points where points[i] = [Xstart, Xend] denotes a balloon whose horizontal diameter stretches
 * between Xstart and Xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with Xstart and Xend is burst by an arrow shot at x if Xstart <= x <= Xend. There is no limit to the number
 * of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 *
 * Constraints:
 * 1 <= points.length <= 10^5
 * points[i].length == 2
 * -2^31 <= Xstart < Xend <= 2^31 - 1
 */
public class MinimumNumberArrowsBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        var arrows = 1;
        var curEnd = points[0][1];
        for (var p : points) {
            var start = p[0];
            var end = p[1];

            if (curEnd < start) {
                arrows++;
                curEnd = end;
            }
        }
        return arrows;
    }
}
