package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Constraints:
 * - nums1.length == m + n
 * - nums2.length == n
 * - 0 <= m, n <= 200
 * - 1 <= m + n <= 200
 * - -109 <= nums1[i], nums2[j] <= 109
 *
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            return;
        }
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if ((p1 >= 0 && p2 < 0) || (p1 >= 0 && p2 >= 0 && nums1[p1] >= nums2[p2])) {
                nums1[p] = nums1[p1];
                --p1;
            } else if (p1 < 0 || (p1 >= 0 && p2 >= 0 && nums1[p1] < nums2[p2])) {
                nums1[p] = nums2[p2];
                --p2;
            }
            --p;
        }
    }
}
