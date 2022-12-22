package week_4;

public class BinaryHeap {
    private final int[] array;
    private int size;

    public BinaryHeap(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 5, 6, 7, 8, 9, 4};
        BinaryHeap binaryHeap = new BinaryHeap(a.length + 1);
        for (int x : a) binaryHeap.insert(x);
        while (!binaryHeap.isEmpty()) System.out.print(binaryHeap.deleteMax() + " ");
    }

    public void print() {
        for (int x : array) System.out.print(x + " ");
        System.out.println(" ");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int x) {
        array[++size] = x;
        swim(size);
    }

    public int deleteMax() {
        int max = array[1];
        swap(1, size--);
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && array[k] > array[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < size) {
            int j = 2 * k;
            if (j < size && array[j] < array[j + 1]) j++;
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
