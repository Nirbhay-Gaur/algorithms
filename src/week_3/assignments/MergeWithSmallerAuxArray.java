package week_3.assignments;

public class MergeWithSmallerAuxArray {

    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        int[] sorted = MergeWithSmallerAuxArray.merge(array, 5);

        for (int i : sorted) System.out.print(i + " ");
    }

    public static int[] merge(int[] a, int N) {

        int[] aux = new int[N];

        for (int x = 0; x < N; x++) {
            aux[x] = a[x];
        }

        int i = 0;
        int j = N;
        for (int k = 0; k < 2 * N; k++) {
            if (i > N - 1) a[k] = a[j++];
            else if (j > 2 * N - 1) a[k] = aux[i++];
            else if (a[j] < aux[i]) a[k] = a[j++];
            else a[k] = aux[i++];
        }

        return a;
    }

}
