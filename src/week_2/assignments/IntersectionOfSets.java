package week_2.assignments;

import java.util.Arrays;

public class IntersectionOfSets {

    public static void main(String[] args) {
    }

    public static int count(Point[] a, Point[] b) {
        int count = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) count++;
            else if (a[i].compareTo(b[j]) == -1) j++;
            else i++;
        }

        return count;
    }

    private class Point implements Comparable<Point> {

        private int x;
        private int y;

        public Point(int a, int b) {
            this.x = a;
            this.y = b;
        }

        public int compareTo(Point that) {
            if (this.x > that.x) return 1;
            if (this.x < that.x) return -1;
            if (this.y > that.y) return 1;
            if (this.y < that.y) return -1;
            return 0;
        }
    }

}
