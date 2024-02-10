package ru.demi.algorithms.leetcode.yandex.offerFor2DaysJanuary2024;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Время-палиндром
 * Мальчик Даня получил на свой седьмой день рождения электронные часы, время в которых выводится на табло в формате
 * HH:MM. Ему немедленно стало интересно, сколько раз за сутки на часах устанавливается время-палиндром. Напомним, что
 * палиндромом называется строка, которая одинаково читается слева направо и справа налево.
 * Несмотря на свой возраст, он был достаточно смышлёным ребёнком, и быстро посчитал, что такое событие происходит ровно
 * 16 раз в день. А именно, в моменты времени
 * 00:00, 01:10, 02:20, 03:30, 04:40, 05:50, 10:01, 11:11, 12:21, 13:31, 14:41, 15:51, 20:02, 21:12, 22:22 и 23:32.
 * Теперь ему стало интересно, сколько палиндромов на часах он бы насчитал, если бы в сутках было не
 * 24 часа, а n, а в одном часе не 60 минут, а m. К сожалению, Даня ещё слишком мал, чтобы решать такие сложные задачи,
 * поэтому он попросил вас помочь.
 * Вам необходимо по количеству часов в сутках n и количеству минут в часе m (1≤n,m<10^5) определить, сколько раз за
 * сутки табло часов покажет время-палиндром. Количество цифр на табло слева и справа от двоеточия одинаково и равно
 * максимуму из длин чисел (n−1) и (m−1) — максимальных значений для часов и минут. Как и в обычных часах, пустые ячейки
 * заполняются нулями.
 *
 * Например, если n=12, а m=1234, то табло принимает значения от 0000:0000 до 0011:1233. Такие часы выводили бы
 * 4 палиндрома в сутки: 0000:0000, 0001:1000, 0010:0100, 0011:1100.
 *
 * Формат ввода
 * В первой и единственной строке входных данных записано два целых положительных числа
 * n и m — количество часов в сутках и количество минут в часе соответственно.
 * Ограничения:
 * 1≤n,m<10^5.
 * Оба числа указаны без ведущих нулей.
 *
 * Формат вывода
 * Выведите одно число — количество раз за сутки, когда табло часов покажет время-палиндром.
 *
 * Пример 1
 * Ввод
 * 24 60
 * Вывод
 * 16
 * Пример 2
 * Ввод
 * 12 1234
 * Вывод
 * 4
 */
public class Test1 {

    // TODO how to make it more efficient?
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();
        String[] split = line.split(" ");
        var dayHours = Integer.parseInt(split[0]);
        var hourMinutes = Integer.parseInt(split[1]);
        var numDigits = Math.max(Integer.toString(dayHours - 1).length(), Integer.toString(hourMinutes - 1).length());

        var palindromes = 0;
        for (var hours = 0; hours < dayHours; hours++) {
            for (var minutes = 0; minutes < hourMinutes; minutes++) {
                var hoursStr = padLeftZeros(Integer.toString(hours), numDigits);
                var minutesStr = padLeftZeros(Integer.toString(minutes), numDigits);
                if (isPalindrome(hoursStr + minutesStr)) {
                    palindromes++;
                }
            }
        }
        System.out.println(palindromes);
    }

    static boolean isPalindrome(String str) {
        for (int start = 0, end = str.length() - 1; start < end; start++, end--) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
        }
        return true;
    }

    static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
