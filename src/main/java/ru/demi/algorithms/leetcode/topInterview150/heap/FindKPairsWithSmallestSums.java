package ru.demi.algorithms.leetcode.topInterview150.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 *
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 10^5
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1 and nums2 both are sorted in non-decreasing order.
 * 1 <= k <= 10^4
 * k <= nums1.length * nums2.length
 */
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var pq = new PriorityQueue<>(Comparator.<Item>comparingInt(v -> v.sum));
        var visited = new HashSet<Idx>();
        pq.add(new Item(nums1[0] + nums2[0], 0, 0));
        visited.add(new Idx(0, 0));

        var res = new ArrayList<List<Integer>>(k);
        while (k-- > 0 && !pq.isEmpty()) {
            var item = pq.remove();
            var i = item.i;
            var j = item.j;
            res.add(List.of(nums1[i], nums2[j]));

            if (i + 1 < nums1.length && !visited.contains(new Idx(i + 1, j))) {
                pq.add(new Item(nums1[i + 1] + nums2[j], i + 1, j));
                visited.add(new Idx(i + 1, j));
            }

            if (j + 1 < nums2.length && !visited.contains(new Idx(i, j + 1))) {
                pq.add(new Item(nums1[i] + nums2[j + 1], i, j + 1));
                visited.add(new Idx(i, j + 1));
            }
        }

        return res;
    }

    record Item(int sum, int i, int j) {}
    record Idx(int i, int j) {}
}
