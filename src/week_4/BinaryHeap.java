package week_4;

public class BinaryHeap {
    public static void main(String[] args) {
        char[] a = new char[]{'c', 's', 'n', 'a', 'b'};
        BinaryHeap binaryHeap = new BinaryHeap(a.length + 1);
        for (char c : a) binaryHeap.insert(c);
        while (!binaryHeap.isEmpty()) System.out.print(binaryHeap.deleteMax() + " ");
    }

    private final char[] array;
    private int N;

    public BinaryHeap(int capacity) {
        array = new char[capacity];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(char x) {
        array[++N] = x;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && array[k] > array[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public char deleteMax() {
        char max = array[1];
        swap(1, N);
        N--;
        sink(1);
        array[N + 1] = '\0';
        return max;
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && array[j + 1] > array[j]) j++;
            if (array[j] < array[k]) break;
            swap(k, j);
            k = j;
        }
    }
}
