 package week_3;

public class MergeSort {

    public static int[] sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
        return a;
    }

    private static void sort(int[] a, int[] aux, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);

        merge(a, aux, low, mid, high);
    }

    private static void merge(int[] a, int[] aux, int low, int mid, int high) {

        for (int x = low; x <= high; x++) {
            aux[x] = a[x];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] sorted = MergeSort.sort(array);
        for (int i : sorted) System.out.print(i + " ");
    }
}
