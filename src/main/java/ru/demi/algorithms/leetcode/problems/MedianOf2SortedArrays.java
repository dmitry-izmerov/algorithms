package ru.demi.algorithms.leetcode.problems;

public class MedianOf2SortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int size = nums1.length + nums2.length;
        int n1 = 0, n2 = 0;
        for (int i = 0; i < size; ++i) {
            if (n1 == nums1.length || (n2 != nums2.length && nums1[n1] > nums2[n2])) {
                nums[i] = nums2[n2];
                ++n2;
            } else {
                nums[i] = nums1[n1];
                ++n1;
            }
        }

        if (nums.length % 2 == 0) {
            int middle = nums.length / 2;
            return (nums[middle - 1] + nums[middle]) / 2d;
        } else {
            return nums[nums.length / 2];
        }
    }
}
