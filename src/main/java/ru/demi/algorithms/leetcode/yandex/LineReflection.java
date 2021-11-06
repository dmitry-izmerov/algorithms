package ru.demi.algorithms.leetcode.yandex;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LineReflection {

    public static boolean isReflected(int[][] points) {
        List<Point> pointList = Arrays.stream(points)
            .map(p -> new Point(p[0], p[1]))
            .distinct()
            .collect(Collectors.toList());

        int size = pointList.size();
        if (size == 1) return true;

        pointList.sort(Comparator.comparingInt(Point::x));

        int middle = size / 2;
        boolean isEven = size % 2 == 0;
        int leftTo = middle;
        int rightFrom = isEven ? middle : middle + 1;

        if (!isEven && getXDiff(pointList, middle, middle - 1) != getXDiff(pointList, middle, middle + 1)) {
            return false;
        }

        int leftMiddleX = pointList.get(leftTo - 1).x();
        int rightMiddleX = pointList.get(rightFrom).x();
        int leftBorder = getBorderIndex(leftTo, i -> --i, i -> i >= 0 && pointList.get(i).x() == leftMiddleX && pointList.get(i).x() == rightMiddleX);
        List<Point> leftPoints = new ArrayList<>(pointList.subList(0, leftBorder));
        leftPoints.sort(Comparator.comparingInt(Point::x).reversed());
        int rightBorder = leftMiddleX != rightMiddleX ? rightFrom : getBorderIndex(rightFrom, i -> ++i, i -> i < pointList.size() && pointList.get(i).x() == leftMiddleX && pointList.get(i).x() == rightMiddleX) + 1;
        List<Point> rightPoints = pointList.subList(rightBorder, pointList.size());

        if (leftPoints.size() != rightPoints.size()) {
            return false;
        }

        for (int i = 0; i < leftPoints.size(); ++i) {
            Point leftPoint = leftPoints.get(i);
            Point rightPoint = rightPoints.get(i);
            if (Math.abs(leftPoint.x() - leftMiddleX) != Math.abs(rightPoint.x() - rightMiddleX)) {
                return false;
            }
            if (leftPoint.y() != rightPoint.y()) {
                return false;
            }
        }

        return true;
    }

    private static int getBorderIndex(int index, Function<Integer, Integer> indexChange, Predicate<Integer> borderControl) {
        int borderVal = index;
        while (true) {
            int nextVal = indexChange.apply(borderVal);
            if (!borderControl.test(nextVal)) {
                break;
            }
            borderVal = nextVal;
        }
        return borderVal;
    }

    private static int getXDiff(List<Point> points, int idx1, int idx2) {
        return Math.abs(points.get(idx1).x() - points.get(idx2).x());
    }

    static final class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Point) obj;
            return this.x == that.x &&
                this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point[" +
                "x=" + x + ", " +
                "y=" + y + ']';
        }
    }
}
