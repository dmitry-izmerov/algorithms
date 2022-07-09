package ru.demi.algorithms.leetcode.yandex.backendSchoolSummer2022;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s = r.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.compute(c, (k, v) -> {
                if (v == null) return 1;
                return ++v;
            });
        }

        String q = r.readLine();
        String[] result = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = q.charAt(i);
            if (c == s.charAt(i)) {
                result[i] = "correct";
                reduceVal(c);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (result[i] != null) continue;

            String output = "absent";
            char c = q.charAt(i);
            if (map.containsKey(c)) {
                output = "present";
                reduceVal(c);
            }
            result[i] = output;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static void reduceVal(char c) {
        map.compute(c, (k, v) -> {
            --v;
            if (v == 0) return null;
            return v;
        });
    }
}
