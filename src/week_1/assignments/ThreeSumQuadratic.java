package week_1.assignments;

import java.util.Arrays;

public class ThreeSumQuadratic {

    private final int[] array;

    public ThreeSumQuadratic(int[] arr) {
        this.array = arr;

        Arrays.sort(this.array);
    }

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};

        ThreeSumQuadratic threeSumQuadratic = new ThreeSumQuadratic(a);
        System.out.println(threeSumQuadratic.find());
    }

    public int find() {
        int length = this.array.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            int k = length - 1;

            while (k > j) {
                int sum = array[i] + array[j] + array[k];
                if (sum == 0) count++;

                if (sum <= 0) j++;
                else k--;
            }
        }
        return count;
    }
}
