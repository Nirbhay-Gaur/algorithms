package week_4.assignments;

public class RandomizedPriorityQueue {

    private int[] array;
    private int N;

    public RandomizedPriorityQueue(int capacity) {
        array = new int[capacity];
        N = 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 5, 1, 6, 7, 4, 8, 9};
        RandomizedPriorityQueue randomizedPriorityQueue = new RandomizedPriorityQueue(a.length + 1);
        for (int i : a) {
            randomizedPriorityQueue.insert(i);
        }

        randomizedPriorityQueue.print();

        while (!randomizedPriorityQueue.isEmpty()) {
            System.out.println(randomizedPriorityQueue.delRandom());

            randomizedPriorityQueue.print();
        }

    }

    public void insert(int x) {
        array[++N] = x;
        swim(N);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void swim(int k) {
        while (k > 1 && array[k] > array[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void swap(int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public int sample() {
        return (int) (Math.random() * N + 1);
    }

    public int delRandom() {
        int random = sample();
        int value = array[random];

        swap(random, N--);
        sink(random);
        array[N + 1] = -1;
        return value;
    }


    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && array[j + 1] > array[j]) j++;
            if (array[k] > array[j]) break;
            swap(j, k);
            k = j;
        }
    }

    public void print() {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
}
