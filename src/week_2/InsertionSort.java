package week_2;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 6, 1, 3, 2, 7, 8, 5};

        int[] sorted = InsertionSort.sort(array);

        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }

    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        return a;
    }
}
