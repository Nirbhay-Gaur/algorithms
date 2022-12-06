package week_2.assignments;

import java.util.Stack;

public class QueueWithStacks {

    private Stack<Integer> inbox = new Stack<>();
    private Stack<Integer> outbox = new Stack<>();

    public QueueWithStacks() {

    }

    public static void main(String[] args) {
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }

    public void enqueue(int x) {
        inbox.add(x);
    }

    public int dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.add(inbox.pop());
            }
        }
        return outbox.pop();
    }

    public boolean isEmpty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }
}
