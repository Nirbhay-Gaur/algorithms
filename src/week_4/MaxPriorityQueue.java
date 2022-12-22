package week_4;

public class MaxPriorityQueue {
    private int[] array;
    private int size = 0;

    public MaxPriorityQueue(int capacity) {
        array = new int[capacity];
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 5, 2, 3, 1, 6, 8, 9, 4};
        int max = 6;
        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(a.length);
        for (int i = 0; i < a.length; i++) {
            if (maxPriorityQueue.getSize() == max) {
                maxPriorityQueue.delete();
            }
            maxPriorityQueue.insert(a[i]);
        }

        for (int i = 0; i < max; i++) {
            System.out.print(maxPriorityQueue.delete() + " ");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(int x) {
        array[size++] = x;
    }

    public int delete() {
        if (isEmpty()) throw new UnsupportedOperationException("MaxPriorityQueue is empty");

        int max = max();
        swap(max);
        return array[--size];
    }

    public int max() {
        int max = 0;
        for (int i = 1; i < getSize(); i++) {
            if (array[i] > array[max]) max = i;
        }
        return max;
    }

    public void swap(int x) {
        int N = getSize() - 1;
        int temp = array[N];
        array[N] = array[x];
        array[x] = temp;
    }
}
