package week_3;

public class NutsAndBolts {
    public static void main(String[] args) {
        int[] nuts = new int[]{3, 4, 1, 2, 5};
        int[] bolts = new int[]{4, 2, 1, 3, 5};

        solve(nuts, bolts, 0, nuts.length - 1);

        for (int nut : nuts) System.out.print(nut + " ");
        System.out.println(' ');
        for (int bolt : bolts) System.out.print(bolt + " ");
    }

    public static void solve(int[] nuts, int[] bolts, int low, int high) {
        if (low >= high) return;
        int idx = partition(nuts, low, high, bolts[high]);
        partition(bolts, low, high, nuts[idx]);
        solve(nuts, bolts, low, idx - 1);
        solve(nuts, bolts, idx + 1, high);
    }

    private static int partition(int[] a, int low, int high, int pivot) {
        int i = low;
        int j = high;
        while (i <= j) {
            if (a[i] > pivot) {
                swap(a, i, j);
                j--;
            } else if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            } else if (a[i] == pivot) {
                swap(a, i, low);
                i++;
            } else if (a[j] == pivot) {
                swap(a, j, low);
                i++;
            }
        }
        swap(a, low, j);
        return j;
    }

    public static void swap(int[] a, int x, int y) {
        int t = a[x];
        a[x] = a[y];
        a[y] = t;
    }

}
