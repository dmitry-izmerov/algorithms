package ru.demi.algorithms.leetcode.yandex.weekendOfferTasks2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;

public class DistroOfCouriers {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String first = r.readLine();
        int k = Integer.parseInt(first);
        String second = r.readLine();
        String[] s = second.split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            String row = r.readLine();
            Arrays.stream(row.split(" ")).limit(n).map(Integer::parseInt).forEach(queue::add);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result += Optional.ofNullable(queue.poll()).orElse(0);
        }

        System.out.println(result);
    }
}


