package week_1;

public class BinarySearch {

    public static void find(int[] a, int x) {
        int hi = a.length - 1;
        int lo = 0;

        while (hi > lo) {
            // use lo + (hi - lo) / 2 to avoid integer overflow;
            // int mid = (hi + lo) / 2;
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == x) {
                System.out.println("Found at " + mid);
                return;
            } else if (a[mid] > x) {
                hi = mid;
            } else if (a[mid] < x) {
                lo = mid;
            }
        }
        System.out.println("Not found!");
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch.find(arr, 6);
    }
}
