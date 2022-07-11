package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.sortingAndSearching;

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
 * - 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion extends VersionControl {

    public FirstBadVersion(int bad) {
        super(bad);
    }

    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        }
        if (this.isBadVersion(1)) {
            return 1;
        }

        return findIndex(n);
    }

    private int findIndex(long versions) {
        var low = 1L;
        var trueHigh = versions;
        while (trueHigh - low > 1) {
            var high = trueHigh;
            while (low < high) {
                var mid = (low + high) / 2;
                var midValue = isBadVersion((int) mid);
                if (midValue) {
                    trueHigh = mid;
                    high = mid - 1;
                } else {
                    low = mid;
                    break;
                }
            }
        }
        return (int) trueHigh;
    }
}

// Provided in runtime.
class VersionControl {

    private final int bad;

    public VersionControl(int bad) {
        this.bad = bad;
    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}
