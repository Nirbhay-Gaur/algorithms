package week_1.assignments;

public class BitonicSearch {

    private final int[] array;

    public BitonicSearch(int[] a) {
        this.array = a;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-12, -4, 0, 1, 3, 7, 12, 17, 51, 43, 21, 9, 2};

        BitonicSearch bitonicSearch = new BitonicSearch(arr);

        System.out.println(bitonicSearch.findIndex(9));
    }

    public int findMax() {
        int length = this.array.length;
        int hi = length - 1;
        int lo = 0;
        int max = -1;

        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (this.array[mid + 1] > this.array[mid]) {
                lo = mid;
            } else if (this.array[mid - 1] > this.array[mid]) {
                hi = mid;
            } else {
                max = mid;
                break;
            }
        }
        return max;
    }

    public int findIndex(int x) {
        int max = this.findMax(); // O(lgN)
        if (this.array[max] == x) return max;

        int indexLeft = this.ascBinarySearch(this.array, 0, max, x); // O(lgN)
        int indexRight = this.desBinarySearch(this.array, max + 1, this.array.length - 1, x); // O(lgN)

        return Math.max(indexLeft, indexRight);
    }

    private int ascBinarySearch(int[] a, int lo, int hi, int x) {
        int index = -1;
        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x) {
                hi = mid - 1;
            } else if (a[mid] < x) {
                lo = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }

    private int desBinarySearch(int[] a, int lo, int hi, int x) {
        int index = -1;

        while (hi > lo) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x) {
                lo = mid + 1;
            } else if (a[mid] < x) {
                hi = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }
}
