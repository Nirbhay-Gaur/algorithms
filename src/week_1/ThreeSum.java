package week_1;

public class ThreeSum {
    public static void main(String[] args) {
        int[] a = new int[]{-40, -20, -10, 0, 5, 10, 30, 40};

        System.out.println(ThreeSum.count(a));
    }

    public static int count(int[] array) {
        int length = array.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int idx = binarySearch(array, -(array[i] + array[j]));
                if (idx != -1) {
                    System.out.println(array[idx]);
                    count++;
                }
            }
        }
        return count;
    }

    public static int binarySearch(int[] arr, int x) {
        int hi = arr.length;
        int lo = 0;

        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] > x) {
                hi = mid - 1;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
