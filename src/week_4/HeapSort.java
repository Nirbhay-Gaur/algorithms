package week_4;

public class HeapSort {
    public static void main(String[] args) {

        int[] a = new int[]{5, 3, 1, 2, 6, 4, 7, 8, 9};
        HeapSort heapSort = new HeapSort(a, a.length + 1);
        int[] sorted = heapSort.sort();
        for (int x : sorted) System.out.print(x + " ");
    }

    private int[] array;
    private int size;

    public HeapSort(int[] a, int N) {
        array = new int[N];
        size = N - 1;
        for (int i = 0; i < a.length; i++) {
            array[i + 1] = a[i];
        }
    }

    public int[] sort() {
        for (int k = size / 2; k >= 1; k--) {
            sink(k);
        }

        while (size != 0) {
            swap(1, size--);
            sink(1);
        }
        return array;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && array[j + 1] > array[j]) j++;
            if (array[k] > array[j]) break;
            swap(j, k);
            k = j;
        }
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
