package ru.demi.algorithms.leetcode.yandex.backendSchoolSummer2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {

    private static final char START = 'S';
    private static final char PATH = '.';

    private static int START_ROW = 0;
    private static int START_COL = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String line = r.readLine();
        String[] split = line.split(" ");
        int rows = Integer.parseInt(split[0]);
        int cols = Integer.parseInt(split[1]);

        char[][] ar = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String row = r.readLine();

            for (int j = 0; j < cols; j++) {
                ar[i][j] = row.charAt(j);
                if (ar[i][j] == START) {
                    START_ROW = i;
                    START_COL = j;
                }
            }
        }

        traverse(ar, START_ROW, START_COL, null);
        for (int i = 0; i < rows; i++) {
            System.out.println(String.valueOf(ar[i]));
        }
    }

    private static void traverse(char[][] ar, int i, int j, Character dir) {
        char cell = ar[i][j];
        if ((cell != PATH && cell != START) || (cell == START && dir != null)) {
            return;
        }

        if (cell == PATH && dir != null) {
            ar[i][j] = dir;
        }

        traverse(ar, i - 1, j, 'U');
        traverse(ar, i + 1, j, 'D');
        traverse(ar, i, j - 1, 'L');
        traverse(ar, i, j + 1, 'R');
    }
}
