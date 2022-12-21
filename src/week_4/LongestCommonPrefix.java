package week_4;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strings = new String[]{"nirbhay", "nirboi", "nigga"};
        String result = solve(strings);
        System.out.print(result);
    }

    public static String solve(String[] strs) {
        if (strs.length == 0) return "";

        String pivot = strs[0];
        for (int i = 0; i < pivot.length(); i++) {
            char c = pivot.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return pivot.substring(0, i);
                }
            }
        }
        return pivot;
    }
}
