package ru.demi.algorithms.leetcode.topInterviewQuestions.easy.math;

public class RomanToInteger {

    public int romanToInt(String s) {
        int total = 0;
        var length = s.length();
        for (int i = 0; i < length;) {
            var converted = 0;
            if (length - i >= 2) {
                converted = convert(s.substring(i, i + 2));
                if (converted != 0) {
                    total += converted;
                    i += 2;
                    continue;
                }
            }
            converted = convert(s.substring(i, i + 1));
            total += converted;
            i++;
        }
        return total;
    }

    private int convert(String chars) {
        return switch (chars) {
            case "M" -> 1000;
            case "CM" -> 900;
            case "D" -> 500;
            case "CD" -> 400;
            case "C" -> 100;
            case "XC" -> 90;
            case "L" -> 50;
            case "XL" -> 40;
            case "X" -> 10;
            case "IX" -> 9;
            case "V" -> 5;
            case "IV" -> 4;
            case "I" -> 1;
            default -> 0;
        };
    }
}
