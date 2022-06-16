package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.math;

import java.util.Arrays;

public class CountPrimes {

    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i*2; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                ++result;
            }
        }

        return result;
    }
}
