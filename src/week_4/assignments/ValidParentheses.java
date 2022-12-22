package week_4.assignments;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String string = "()[]{()[]{[]{()}}}";
        System.out.print(isValid(string) ? "True" : "False");
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else {
                char c = stack.pop();
                if (c != s.charAt(i)) return false;
            }
        }

        return stack.isEmpty();
    }
}
