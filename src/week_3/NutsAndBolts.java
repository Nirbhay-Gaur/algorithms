package week_3;

public class NutsAndBolts {
    public static void main(String[] args) {
        int[] nuts = {2, 1, 4, 3, 5};
        int[] bolts = {5, 3, 4, 2, 1};

        solve(nuts, bolts, 0, 4);

        print(nuts);
        print(bolts);
    }

    private static void print(int[] a) {
        for (int x : a) System.out.print(x + " ");
        System.out.println(" ");
    }

    private static int partition(int[] array, int low, int high, int pivot) {
        int i = low;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            } else if (array[j] == pivot) {
                swap(array, j, high);
                j--;
            }
        }
        swap(array, i, high);
        return i;
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void solve(int[] nuts, int[] bolts, int low, int high) {
        if (high <= low) return;
        int pivot = partition(nuts, low, high, bolts[high]);
        partition(bolts, low, high, nuts[pivot]);
        solve(nuts, bolts, low, pivot - 1);
        solve(nuts, bolts, pivot + 1, high);
    }
}
