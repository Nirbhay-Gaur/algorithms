package week_4;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strings = new String[]{"dog", "cat", "racecar"};
        String result = solve(strings);
        System.out.print(result);
    }

    public static String solve(String[] strs) {
        if (strs.length == 0) return "";

        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]) {
                break;
            } else {
                result.append(first[i]);
            }
        }
        return result.toString();
    }
}
