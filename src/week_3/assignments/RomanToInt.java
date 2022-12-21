package week_3.assignments;

import java.util.HashMap;

public class RomanToInt {

    private HashMap<Character, Integer> table;

    public RomanToInt() {
        table = new HashMap<>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInt roman = new RomanToInt();
        String s1 = "III";
        System.out.println(roman.romanToInt(s1));

        String s2 = "LVIII";
        System.out.println(roman.romanToInt(s2));

        String s3 = "MCMXCIV";
        System.out.println(roman.romanToInt(s3));
    }

    private int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && table.get(s.charAt(i)) < table.get(s.charAt(i + 1))) {
                sum += table.get(s.charAt(i + 1)) - table.get(s.charAt(i));
                i++;
            } else {
                sum += table.get(s.charAt(i));
            }
        }
        return sum;
    }

}
