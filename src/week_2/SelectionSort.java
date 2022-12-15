package week_2;

public class SelectionSort {


    public static void main(String[] args) {
        int[] array = new int[]{9, 5, 2, 6, 8, 4, 1, 3, 7};

        int[] sorted = SelectionSort.sort(array);

        for (int j : sorted) {
            System.out.print(j + " ");
        }
    }

    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
