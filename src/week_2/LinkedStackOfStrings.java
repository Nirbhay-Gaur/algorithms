package week_2;

public class LinkedStackOfStrings {

    private Node first = null;
    private int size = 0;

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();

        stack.push("abc");
        stack.push("def");
        stack.push("ghi");
        stack.push("jkl");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " " + stack.getSize());
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String x) {
        Node oldFirst = first;
        first = new Node();
        first.item = x;
        first.next = oldFirst;
        size++;
    }

    public int getSize() {
        return this.size;
    }

    public String pop() {
        String string = first.item;
        first = first.next;
        size--;
        return string;
    }

    private static class Node {
        String item;
        Node next;
    }

}
