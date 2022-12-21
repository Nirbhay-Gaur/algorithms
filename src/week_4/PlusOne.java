package week_4;

public class PlusOne {
    public static void main(String[] args) {
        int[] array = new int[]{9, 9};
        int[] result = plusOne(array);
        for (int s : result) System.out.print(s + " ");
    }

    public static int[] plusOne(int[] digits) {
        int N = digits.length - 1;
        while (digits[N] == 9) {
            if (N == 0) break;
            digits[N] = 0;
            N--;
        }
        if (digits[N] == 9) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            newDigits[1] = 0;
            for (int i = 2; i < newDigits.length; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        } else {
            digits[N] += 1;
            return digits;
        }
    }
}
