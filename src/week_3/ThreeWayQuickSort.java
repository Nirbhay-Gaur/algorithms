package week_3;

public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 8, 1, 5, 3, 2, 3, 1, 6, 3, 7, 2, 8, 1, 0, 8, 3, 0};
        int[] sorted = ThreeWayQuickSort.sort(array);
        for (int i : sorted) System.out.print(i + " ");
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        int lt = lo;
        int gt = hi;
        int i = lo;
        int v = a[lo];

        while (i <= gt) {

            if (a[i] < v) {
                int temp = a[i];
                a[i] = a[lt];
                a[lt] = temp;

                lt++;
                i++;
            } else if (a[i] > v) {
                int temp = a[i];
                a[i] = a[gt];
                a[gt] = temp;

                gt--;
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static int[] sort(int[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
        return a;
    }
}
