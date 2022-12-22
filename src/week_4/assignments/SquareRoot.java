package week_4.assignments;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(sqrt(81));
        System.out.println(sqrt(256));
        System.out.println(sqrt(1024));
        System.out.println(sqrt(99999));

    }

    public static int sqrt(int x) {
        if (x == 1) return 1;
        int l = 0;
        int r = x;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) l = mid;
            else if (mid > x / mid) r = mid;
        }
        return l;
    }
}
