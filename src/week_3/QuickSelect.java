package week_3;

public class QuickSelect {

    private static int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[++i] < a[low])
                if (i == high) break;
            while (a[low] < a[--j])
                if (j == low) break;

            if (i >= j) break;
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        int r = a[low];
        a[low] = a[j];
        a[j] = r;
        return j;
    }


    public static int select(int[] a, int k) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j > k) hi = j - 1;
            else if (j < k) lo = j + 1;
            else return a[k];
        }
        return a[k];
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(QuickSelect.select(array, 7));
    }
}
