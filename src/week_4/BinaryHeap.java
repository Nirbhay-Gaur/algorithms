package week_4;

public class BinaryHeap {

    private int[] array;
    private int size = 0;


    public BinaryHeap(int capacity) {
        array = new int[capacity];
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 3, 1, 5, 6, 8, 7, 9};
        BinaryHeap binaryHeap = new BinaryHeap(a.length + 1);
        for (int x : a) binaryHeap.insert(x);

        while (!binaryHeap.isEmpty()) {
            System.out.print(binaryHeap.deleteMax() + " ");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void swim(int k) {
        while (k > 1 & array[k / 2] < array[k]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && array[j] < array[j + 1]) j++;
            if (array[j] < array[k]) break;
            swap(j, k);
            k = j;
        }
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

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
