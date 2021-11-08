package ru.demi.algorithms.leetcode.yandex.weekendOfferTasks2021;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TechDebt {

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String first = r.readLine();
        String[] s = first.split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        String second = r.readLine();
        PriorityQueue<Integer> days = Arrays.stream(second.split(" ")).map(Integer::parseInt).limit(n).collect(Collectors.toCollection(PriorityQueue::new));
        int result = 0;
        for (int i = 0; i <= k || days.isEmpty(); ++i) {
            int day = days.remove();
            days.add(day + x);
            result = day;
        }

        System.out.println(result);
    }
}
