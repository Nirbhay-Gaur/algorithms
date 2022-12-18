package week_3;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{8, 5, 9, 4, 7, 3, 6, 1, 0, 2};
        int[] sorted = QuickSort.sort(array);
        for (int i : sorted) System.out.print(i + " ");
    }

    private static void sort(int[] a, int low, int high) {
        if (low >= high) return;
        int partition = partition(a, low, high);
        sort(a, low, partition);
        sort(a, partition + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[++i] < a[low]) {
                if (i == high) break;
            }
            while (a[low] < a[--j]) {
                if (j == low) break;
            }
            if (i >= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int t = a[low];
        a[low] = a[j];
        a[j] = t;
        return j;
    }

    public static int[] sort(int[] array) {
        Collections.shuffle(Arrays.asList(array));
        sort(array, 0, array.length - 1);
        return array;
    }
}
