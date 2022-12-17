package week_3.assignments;

public class CountInversions {

    private int counter = 0;

    public static void main(String[] args) {
        int[] array = new int[]{6, 3, 5, 2, 7};

        CountInversions countInversions = new CountInversions();
        int[] aux = new int[array.length];
        countInversions.count(array, aux, 0, array.length - 1);

        System.out.print(countInversions.counter);
    }


    public void count(int[] a, int[] aux, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        count(a, aux, low, mid);
        count(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }


    private void merge(int[] a, int[] aux, int low, int mid, int high) {

        for (int x = low; x <= high; x++) {
            aux[x] = a[x];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
                counter += mid - i + 1;
            } else a[k] = aux[i++];
        }
    }

}
