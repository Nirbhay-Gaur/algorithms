package week_3;

public class RichestCustomerWealth {

    public static void main(String[] args) {
        int[][] a1 = new int[][]{{1, 2, 3}, {3, 2, 1}};
        int[][] a2 = new int[][]{{1, 5}, {7, 3}, {3, 5}};
        int[][] a3 = new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(RichestCustomerWealth.maximumWealth(a1));
        System.out.println(RichestCustomerWealth.maximumWealth(a2));
        System.out.println(RichestCustomerWealth.maximumWealth(a3));
    }

    private static int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (max < sum) max = sum;
        }
        return max;
    }
}
