package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays
 * and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {

    public int[] getIntersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int[][] arrs = new int[][] { nums1, nums2 };
        if (nums2.length < nums1.length) {
            arrs = new int[][] { nums2, nums1 };
        }

        for (int n : arrs[0]) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int n : arrs[1]) {
            int v = map.getOrDefault(n, 0);
            if (v == 0) continue;
            res.add(n);
            map.put(n, v - 1);
        }

        return res.stream().mapToInt(n -> n).toArray();
    }
}
