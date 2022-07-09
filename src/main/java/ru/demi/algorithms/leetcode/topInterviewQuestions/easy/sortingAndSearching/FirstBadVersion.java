package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 *
 * Constraints:
 * - 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(Map<Integer, Boolean> values) {
        super(values);
    }

    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        if (this.isBadVersion(1)) {
            return 1;
        }

        var versions = IntStream.rangeClosed(1, n)
            .boxed()
            .collect(Collectors.toList());

        var oldIndex = Integer.MIN_VALUE;
        var foundIndex = 0;
        while (oldIndex != foundIndex && foundIndex < n) {
            var subList = versions.subList(foundIndex, versions.size());
            System.out.println("sublist = " + subList);
            oldIndex = foundIndex;
            var sizeDiff = versions.size() - subList.size();
            System.out.println("sizeDiff = " + sizeDiff);
            foundIndex = sizeDiff + findIndex(subList) + 1;
            System.out.println("foundIndex = " + foundIndex);
            if (foundIndex == 0) {
                return oldIndex;
            }
        }

        return foundIndex;
    }

    private int findIndex(List<Integer> versions) {
        var low = 0;
        var high = versions.size() - 1;
        while (true) {
            var mid = (low + high) / 2;
            System.out.println("mid = " + mid);
            var midValue = this.isBadVersion(versions.get(mid));
            System.out.println("midValue = " + midValue);

            if (mid == low && midValue) {
                System.out.println("in if (mid == low && midValue) {");
                return -1;
            } else if (midValue) {
                System.out.println("in } else if (midValue) {");
                high = mid - 1;
            } else {
                System.out.println("in else");
                return mid;
            }
        }
    }
}

// Provided in runtime.
class VersionControl {
    private Map<Integer, Boolean> values;

    public VersionControl(Map<Integer, Boolean> values) {
        this.values = values;
    }

    boolean isBadVersion(int version) {
        return values.get(version);
    }
}
