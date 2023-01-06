package week_4;

public class MinPriorityQueue {

    private int[] array;
    private int N;

    public MinPriorityQueue(int capacity) {
        array = new int[capacity];
        N = 0;
    }

    public void insert(int x) {
        array[++N] = x;
        swim(N);
    }

    public int deleteMin() {
        int min = array[1];
        swap(1, N--);
        sink(1);
        return min;
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && array[j] > array[j + 1]) j++;
            if (array[k] < array[j]) break;
            swap(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && array[k] < array[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 1, 2, 4, 6, 5};
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue(array.length + 1);

        for (int x : array) {
            minPriorityQueue.insert(x);
        }

        while (!minPriorityQueue.isEmpty()) {
            System.out.print(minPriorityQueue.deleteMin() + " ");
        }
    }
}
