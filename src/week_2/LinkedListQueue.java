package week_2;

public class LinkedListQueue {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public LinkedListQueue() {

    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueque("abc");
        linkedListQueue.enqueque("def");
        linkedListQueue.enqueque("ghi");
        linkedListQueue.enqueque("jkl");
        linkedListQueue.enqueque("mno");

        while (!linkedListQueue.isEmpty()) {
            System.out.println(linkedListQueue.dequeue() + " " + linkedListQueue.getSize());
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueque(String x) {
        Node oldLast = last;
        last = new Node();
        last.item = x;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public String dequeue() {
        String string = first.item;
        first = first.next;
        size--;
        return string;
    }

    public int getSize() {
        return this.size;
    }

    private class Node {
        String item;
        Node next;
    }
}
